package com.example.university.services;

import com.example.university.entity.Advt;
import com.example.university.entity.Post;
import com.example.university.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PostService {
    private static String INSERT_QUERY = "INSERT INTO post (author, title, text, hashtags) VALUES(?, ?, ?, ?)";
    private Connection connection;

    public PostService(Connection connection) {
        this.connection = connection;

    }

    public boolean addPost(Post post) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        statement.setString(1, post.getAuthor());
        statement.setString(2, post.getTitle());
        statement.setString(3, post.getText());
        statement.setString(4, post.getHashtags());
        return statement.executeUpdate() > 0;
    }

    public static void main(String[] args) {
        PostService postService = new PostService(ConnectionProvider.getConn().getConnection());
        String author = "Regina";
        String title = "Title";
        String text = "Text";
        String hashtags = "#hashtag";

        Post post = new Post(author, title, text, hashtags);

        try {
            boolean addRes = postService.addPost(post);
            System.out.println("addAdvt: " + addRes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
