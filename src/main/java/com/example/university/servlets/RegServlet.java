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

public class RegServlet extends HttpServlet {
    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setMaxInactiveInterval(-1);
        response.setContentType("text/html;charset=UTF-8");
        UserService userService = new UserService(ConnectionProvider.getConn().getConnection());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            boolean autentificationResult = userService.authUser(username, password);
            if (autentificationResult) {
                Helper.redirect(response, request, "/survey");
            } else {
                try {
                    Template template = ConfigSingleton.getConfig().getTemplate("/start/reg.ftl");
                    template.process(null, response.getWriter());
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
        String role = request.getParameter("role");
        User user = new User(username, name, lastname, role);
        try {
            boolean autentificationResult = userService.authUser(username, password);
            if (autentificationResult) {
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
    }
}
