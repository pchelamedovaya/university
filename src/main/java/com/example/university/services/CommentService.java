package com.example.university.services;

import com.example.university.entity.Comment;
import com.example.university.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentService {
    private static String INSERT_QUERY = "INSERT INTO comment (post_id, author, text) VALUES(?, ?, ?)";
    private Connection connection;

    public CommentService(Connection connection) {
        this.connection = connection;

    }

    public boolean addComment(Comment comment) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        statement.setInt(1, comment.getPostId());
        statement.setString(2, comment.getAuthor());
        statement.setString(3, comment.getText());
        return statement.executeUpdate() > 0;
    }

    public static void main(String[] args) {
        CommentService commentService = new CommentService(ConnectionProvider.getConn().getConnection());
        String author = "Test";
        String text = "Test";
        int post_id = 1;
        Comment comment = new Comment(post_id, author, text);
        try {
            boolean addRes = commentService.addComment(comment);
            System.out.println("addComm: " + addRes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
