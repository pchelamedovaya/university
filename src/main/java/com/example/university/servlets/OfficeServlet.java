package com.example.university.servlets;

import com.example.university.dao.NewsDAO;
import com.example.university.dao.UserDAO;
import com.example.university.entity.News;
import com.example.university.entity.User;
import com.example.university.utils.ConfigSingleton;
import freemarker.template.Template;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OfficeServlet extends HttpServlet {

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("ACCOUNT");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
