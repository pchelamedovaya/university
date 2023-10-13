package com.example.university.servlets;

import com.example.university.dao.NewsDAO;
import com.example.university.utils.ConfigSingleton;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NewsListServlet extends HttpServlet {
    private NewsDAO newsDAO;
    private final int NEWS_LIMIT = 5;

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        newsDAO = (NewsDAO) getServletContext().getAttribute("newsDAO");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Template template = ConfigSingleton.getConfig().getTemplate("/news/list.ftl");
            Map<String, Object> newsList = new HashMap<>();
            newsList.put("newsList", newsDAO.getNewsList(NEWS_LIMIT));
            template.process(newsList, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/news/list.ftl");
    }
}
