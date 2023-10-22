package com.example.university.servlets;

import com.example.university.helpers.Helper;
import com.example.university.services.UserService;
import com.example.university.utils.ConfigSingleton;
import com.example.university.utils.ConnectionProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AuthServlet extends HttpServlet {
    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
                    Template template = ConfigSingleton.getConfig().getTemplate("/start/auth.ftl");
                    Map<String, Object> root = new HashMap<>();
                    root.put("autentificated", autentificated);
                    template.process(root, response.getWriter());
                } catch (TemplateException e) {
                    throw new RuntimeException(e);
                }
                getServletContext().getRequestDispatcher("/WEB-INF/view/start/auth.ftl").forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserService userService = new UserService(ConnectionProvider.getConn().getConnection());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberme");
        try {
            boolean autentificationResult = userService.authUser(username, password);
            if (autentificationResult) {
                request.setAttribute("autentificated", true);
                Helper.redirect(response, request, "/survey");
                if (rememberMe != null) {
                    Cookie authCookie = new Cookie("auth", "true");
                    response.addCookie(authCookie);
                    Helper.redirect(response, request, "/survey");
                }
                request.getSession().setAttribute("auth", username);
            } else {
                Helper.redirect(response, request, "/reg");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}