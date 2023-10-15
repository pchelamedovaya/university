package com.example.university.servlets;

import com.example.university.dao.UserDAO;
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

public class SearchForUsersServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("SEARCH");
//    }
    private UserDAO userDAO;
    private final int USERS_LIMIT = 8;

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        userDAO = (UserDAO) getServletContext().getAttribute("userDAO");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Template template = ConfigSingleton.getConfig().getTemplate("/users/list.ftl");
            Map<String, Object> newsList = new HashMap<>();
            newsList.put("usersList", userDAO.getAllUsers(USERS_LIMIT));
            template.process(newsList, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/users/list.ftl");
    }
}
