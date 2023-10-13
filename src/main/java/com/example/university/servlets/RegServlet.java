package com.example.university.servlets;

import com.example.university.entity.User;
import com.example.university.helpers.Helper;
import com.example.university.utils.ConfigSingleton;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setMaxInactiveInterval(-1);
        response.setContentType("text/html");

        if (Helper.isAuth(request, "auth")) {
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
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (Helper.isAuth(request, "auth")) {
            Helper.redirect(response, request, "/survey");
        } else {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            request.getSession().setAttribute("user", new User(username, password));
            Helper.checkReg(request);
            Helper.redirect(response, request, "/auth");
        }
    }
}
