package com.example.university.servlets;

import com.example.university.entity.User;
import com.example.university.helpers.Helper;
import com.example.university.services.UserService;
import com.example.university.utils.ConfigSingleton;
import com.example.university.utils.ConnectionProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RegServlet extends HttpServlet {
    private final String USERNAME_REG = "^[a-zA-Z0-9_]+$";
    private final String NAME_LASTNAME_REG = "^[A-Z][a-z]*(?:-[A-Z][a-z]*)*$";
    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
    }

    public boolean inputIsValid(String username, String name, String lastname, String password) {
        if (
                username.isEmpty() ||
                name.isEmpty() ||
                lastname.isEmpty() ||
                password.isEmpty() ||
                !username.matches(USERNAME_REG) ||
                !name.matches(NAME_LASTNAME_REG) ||
                !username.matches(NAME_LASTNAME_REG)
        ) {
            return false;
        }
        return true;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setMaxInactiveInterval(-1);
        response.setContentType("text/html;charset=UTF-8");
        UserService userService = new UserService(ConnectionProvider.getConn().getConnection());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean autentificated = false;
        try {
            boolean autentificationResult = userService.authUser(username, password);
            if (autentificationResult) {
                autentificated = true;
                request.setAttribute("autentificated", autentificated);
                Helper.redirect(response, request, "/survey");
            } else {
                try {
                    Template template = ConfigSingleton.getConfig().getTemplate("/start/reg.ftl");
                    Map<String, Object> root = new HashMap<>();
                    root.put("autentificated", autentificated);
                    template.process(root, response.getWriter());
                } catch (TemplateException e) {
                    throw new RuntimeException(e);
                }
                getServletContext().getRequestDispatcher("/WEB-INF/view/start/reg.ftl").forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserService userService = new UserService(ConnectionProvider.getConn().getConnection());
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        User user = new User(username, name, lastname);
        if (!inputIsValid(username, name, lastname, password)) {
            try {
                boolean autentificationResult = userService.authUser(username, password);
                if (autentificationResult) {
                    request.setAttribute("autentificated", true);
                    Helper.redirect(response, request, "/survey");
                } else {
                    try {
                        boolean registrationResult = userService.registerUser(user, password);
                        if (registrationResult) {
                            Helper.redirect(response, request, "/auth");
                        } else {
                            response.getWriter().println("REG ERROR");
                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.getWriter().println("INPUT VALUE ERROR");
        }
    }
}
