package com.example.university.servlets;

import com.example.university.dao.CommentDAO;
import com.example.university.dao.PostDAO;
import com.example.university.dao.UserDAO;
import com.example.university.entity.Comment;
import com.example.university.entity.Post;
import com.example.university.entity.User;
import com.example.university.helpers.Helper;
import com.example.university.services.CommentService;
import com.example.university.utils.ConfigSingleton;
import com.example.university.utils.ConnectionProvider;
import freemarker.template.Template;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CommentServlet extends HttpServlet {
    private PostDAO postDAO;
    private UserDAO userDAO;
    private CommentDAO commentDAO;

    public void init() {
        ConfigSingleton.setServletContext(this.getServletContext());
        postDAO = (PostDAO) getServletContext().getAttribute("postDAO");
        commentDAO = (CommentDAO) getServletContext().getAttribute("commentDAO");
        userDAO = (UserDAO) getServletContext().getAttribute("userDAO");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            String id = req.getParameter("id");
            Post post = postDAO.getDetail(Integer.parseInt(id));
            if (post != null) {
                Map<String, Object> root = new HashMap<>();
                root.put("author", post.getAuthor());
                root.put("title", post.getTitle());
                root.put("text", post.getText());
                root.put("hashtags", post.getHashtags());
                root.put("commentList", commentDAO.getCommentList(Integer.parseInt(id)));
                root.put("postId", id);
                root.put("autentificated", true);

                HttpSession session = req.getSession(false);
                if (session != null && session.getAttribute("username") != null) {
                    String username = (String) session.getAttribute("username");
                    User user = userDAO.getUserInfo(username);
                    root.put("user", user);
                } else {
                    System.out.println("SESSION DOES NOT EXIST");
                }

                Template template = ConfigSingleton.getConfig().getTemplate("/forum/detail.ftl");
                template.process(root, resp.getWriter());
            } else {
                resp.getWriter().println("POST NOT FOUND");
            }
            getServletContext().getRequestDispatcher("/WEB-INF/view/forum/detail.ftl").forward(req, resp);
        } catch (Exception e){
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentService commentService = new CommentService(ConnectionProvider.getConn().getConnection());
        try {
            String author = req.getParameter("author");
            String text = req.getParameter("text");
            String postIdP = req.getParameter("postId");
            int postId = Integer.parseInt(postIdP);

            Comment comment = new Comment(postId, author, text);
            boolean addResult = commentService.addComment(comment);
            if (addResult) {
                Helper.redirect(resp, req, "/forum/detail?id=" + postId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
