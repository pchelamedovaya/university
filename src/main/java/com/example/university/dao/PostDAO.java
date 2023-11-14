package com.example.university.dao;

import com.example.university.entity.Comment;
import com.example.university.entity.Post;
import com.example.university.entity.User;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostDAO {
    private static ConnectionProvider connectionProvider;
    private final String SELECT_INFO = "SELECT name FROM users WHERE username = ?";


    public PostDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<Post> getPostList() throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM post");
        ResultSet result = preparedStatement.executeQuery();
        List<Post> postList = new ArrayList<>();
        while (result.next()) {
            Post post = new Post(
                    result.getInt("id"),
                    result.getString("author"),
                    result.getString("title"),
                    result.getString("text"),
                    result.getString("hashtags")
            );
            postList.add(post);
        }
        return postList;
    }

    public Post getDetail(int id) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM post WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        boolean hasFirst = result.next();
        if (hasFirst) {
            return new Post(
                    result.getInt("id"),
                    result.getString("author"),
                    result.getString("title"),
                    result.getString("text"),
                    result.getString("hashtags")
            );
        } else {
            return null;
        }
    }

    public User getUserInfo(String username) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = this.connectionProvider.
                    getConnection().prepareStatement(SELECT_INFO);
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                user.setName(result.getString("name"));
                user.setUsername(result.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
