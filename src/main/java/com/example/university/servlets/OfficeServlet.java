package com.example.university.servlets;

import com.example.university.dao.UserDAO;
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
        Template template = ConfigSingleton.getConfig().getTemplate("/account/office.ftl");
        try {
            template.process(map, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
