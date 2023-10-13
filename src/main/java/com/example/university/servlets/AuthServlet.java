package com.example.university.servlets;

import com.example.university.dao.NewsDAO;
import com.example.university.dao.UserDAO;
import com.example.university.helpers.Helper;
import com.example.university.entity.User;
import com.example.university.utils.ConfigSingleton;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AuthServlet extends HttpServlet {

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        if (Helper.isAuth(request, "auth")) {
            Helper.redirect(response, request, "/survey");
        } else {
            response.setContentType("text/html");
            try {
                Template template = ConfigSingleton.getConfig().getTemplate("/start/auth.ftl");
                template.process(null, response.getWriter());
            } catch (TemplateException e) {
                throw new RuntimeException(e);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/view/start/auth.ftl").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (Helper.isAuth(request, "auth")) {
            Helper.redirect(response, request, "/survey");
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rememberMe = request.getParameter("rememberme");
            User userObj = (User) request.getServletContext().getAttribute("user");
            if (userObj != null) {
                if (userObj.getUsername().equals(username) && userObj.getPassword().equals(password)) {
                    request.getSession().setAttribute("auth", userObj);
                    if (rememberMe != null) response.addCookie(new Cookie("auth", "true"));
                    Helper.redirect(response, request, "/survey");
                } else {
                    Helper.redirect(response, request, "/auth");
                }
            } else {
                Helper.redirect(response, request, "/reg");
            }
        }
    }
}
