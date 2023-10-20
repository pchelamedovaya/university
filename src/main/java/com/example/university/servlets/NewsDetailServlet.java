package com.example.university.servlets;

import com.example.university.dao.NewsDAO;
import com.example.university.entity.News;
import com.example.university.utils.ConfigSingleton;
import freemarker.template.Template;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class NewsDetailServlet extends HttpServlet {
    private NewsDAO newsDAO;

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        newsDAO = (NewsDAO) getServletContext().getAttribute("newsDAO");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            String id = req.getParameter("id");
            News news = newsDAO.getDetail(Integer.parseInt(id));
            Map<String, Object> root = new HashMap<>();
            root.put("title", news.getTitle());
            root.put("url", news.getUrl());
            root.put("category", news.getCategory());
            root.put("shortdescription", news.getShortdescription());
            root.put("content", news.getContent());
            root.put("date", news.getDate());
            root.put("autentificated", true);
            Template template = ConfigSingleton.getConfig().getTemplate("/news/detail.ftl");
            template.process(root, resp.getWriter());

            req.setAttribute("news", news);
            getServletContext().getRequestDispatcher("/WEB-INF/view/news/detail.ftl").forward(req, resp);
        } catch (Exception e){
            throw new ServletException(e);
        }
    }
}
