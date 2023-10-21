package com.example.university.servlets;

import com.example.university.dao.AdminMemberDAO;
import com.example.university.dao.FacultyDAO;
import com.example.university.utils.ConfigSingleton;
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

public class AboutServlet extends HttpServlet {
    private AdminMemberDAO adminMemberDAO;
    private FacultyDAO facultyDAO;
    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        adminMemberDAO = (AdminMemberDAO) getServletContext().getAttribute("adminMemberDAO");
        facultyDAO = (FacultyDAO) getServletContext().getAttribute("facultyDAO");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Template template = ConfigSingleton.getConfig().getTemplate("/about/about.ftl");
            Map<String, Object> aboutList = new HashMap<>();
            aboutList.put("adminMemberList", adminMemberDAO.getAdminMemberList());
            aboutList.put("facultyList", facultyDAO.getFacultyList());
            template.process(aboutList, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/about/about.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
