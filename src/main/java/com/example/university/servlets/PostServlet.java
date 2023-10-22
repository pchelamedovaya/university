package com.example.university.servlets;

import com.example.university.dao.PostDAO;
import com.example.university.entity.Post;
import com.example.university.helpers.Helper;
import com.example.university.services.PostService;
import com.example.university.utils.ConfigSingleton;
import com.example.university.utils.ConnectionProvider;
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

public class PostServlet extends HttpServlet {
    private PostDAO postDAO;
    private final int NEWS_LIMIT = 15;

    private static ConnectionProvider connectionProvider;

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        postDAO = (PostDAO) getServletContext().getAttribute("postDAO");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            Template template = ConfigSingleton.getConfig().getTemplate("/forum/post.ftl");
            Map<String, Object> postList = new HashMap<>();
            postList.put("postList", postDAO.getPostList(NEWS_LIMIT));
            postList.put("autentificated", true);
            template.process(postList, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/forum/post.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostService(ConnectionProvider.getConn().getConnection());
        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        String hashtags = req.getParameter("hashtags");
        try {
            Post post = new Post(author, title, text, hashtags);
            boolean addResult = postService.addPost(post);
            if (addResult) {
                Helper.redirect(resp, req, "/forum");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
