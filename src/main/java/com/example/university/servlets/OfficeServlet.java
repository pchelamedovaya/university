package com.example.university.servlets;

import com.example.university.dao.UserDAO;
import com.example.university.entity.User;
import com.example.university.helpers.Helper;
import com.example.university.utils.ConfigSingleton;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OfficeServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        userDAO = (UserDAO) getServletContext().getAttribute("userDAO");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, Object> map = new HashMap<>();
        map.put("autentificated", true);

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            User user = userDAO.getUserInfo(username);
            map.put("user", user);
        } else {
            System.out.println("SESSION DOES NOT EXIST");
        }

        Template template = ConfigSingleton.getConfig().getTemplate("/account/office.ftl");
        try {
            template.process(map, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String institute = request.getParameter("institute");
        String curGroup = request.getParameter("curGroup");
        String bio = request.getParameter("bio");

        userDAO.ChangingUserInfo(username, name, lastname, gender, institute, curGroup, bio);

        Helper.redirect(response, request, "/office");
    }
}