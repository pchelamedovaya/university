package com.example.university.utils;

import com.example.university.dao.*;
//import com.example.university.dao.UserDAO;
//import com.example.university.service.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionProvider connectionProvider = ConnectionProvider.getConn();
        sce.getServletContext().setAttribute("newsDAO", new NewsDAO(connectionProvider));
        sce.getServletContext().setAttribute("userDAO", new UserDAO(connectionProvider));
        sce.getServletContext().setAttribute("advtDAO", new AdvtDAO(connectionProvider));
        sce.getServletContext().setAttribute("adminMemberDAO", new AdminMemberDAO(connectionProvider));
        sce.getServletContext().setAttribute("facultyDAO", new FacultyDAO(connectionProvider));
        sce.getServletContext().setAttribute("specialityDAO", new SpecialityDAO(connectionProvider));
    }
}
