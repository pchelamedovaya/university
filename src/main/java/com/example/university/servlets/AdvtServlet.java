package com.example.university.servlets;

import com.example.university.dao.AdvtDAO;
import com.example.university.dao.UserDAO;
import com.example.university.entity.Advt;
import com.example.university.entity.User;
import com.example.university.helpers.Helper;
import com.example.university.services.AdvtService;
import com.example.university.utils.ConfigSingleton;
import com.example.university.utils.ConnectionProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class AdvtServlet extends HttpServlet {
    private AdvtDAO advtDAO;
    private UserDAO userDAO;
    private final int NEWS_LIMIT = 15;

    private static ConnectionProvider connectionProvider;

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        advtDAO = (AdvtDAO) getServletContext().getAttribute("advtDAO");
        userDAO = (UserDAO) getServletContext().getAttribute("userDAO");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get");
        resp.setContentType("text/html;charset=UTF-8");
        try {
            Template template = ConfigSingleton.getConfig().getTemplate("/help/advt.ftl");
            Map<String, Object> advtList = new HashMap<>();
            advtList.put("advtList", advtDAO.getAdvtList(NEWS_LIMIT));
            advtList.put("autentificated", true);

            HttpSession session = req.getSession(false);
            System.out.println("session " + session);
            if (session != null) {
                System.out.println(session.getAttribute("username"));
            }
            if (session != null && session.getAttribute("username") != null) {
                String username = (String) session.getAttribute("username");
                User user = userDAO.getUserInfo(username);
                advtList.put("user", user);
            } else {
                System.out.println("SESSION DOES NOT EXIST");
            }

            template.process(advtList, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/help/advt.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=UTF-8");
        String title = req.getParameter("title");
        String format = req.getParameter("format");
        String time = req.getParameter("time");
        String url = req.getParameter("url");
        String nameAuthor = req.getParameter("nameAuthor");
        String lastnameAuthor = req.getParameter("lastnameAuthor");
        String message = req.getParameter("message");
        try {
            Advt advt = new Advt(title, format, time, url, nameAuthor, lastnameAuthor, message);
            AdvtService advtService = new AdvtService(ConnectionProvider.getConn().getConnection());
            boolean addResult = advtService.AddAdvt(advt);
            if (addResult) {
                Helper.redirect(resp, req, "/help");
            }
        } catch (SQLException e) {
            resp.getWriter().write(e.getMessage());
        }
    }
}