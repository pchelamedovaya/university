package com.example.university.dao;

import com.example.university.entity.Post;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private static ConnectionProvider connectionProvider;

    public PostDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public static List<Post> getPostList(int limit) throws SQLException {
        PreparedStatement preparedStatement = connectionProvider.getConnection().prepareStatement("SELECT * FROM post LIMIT ?");
        preparedStatement.setInt(1, limit);
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
}
