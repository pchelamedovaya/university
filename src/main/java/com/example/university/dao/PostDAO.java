package com.example.university.dao;

import com.example.university.entity.Comment;
import com.example.university.entity.Post;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostDAO {
    //language=sql
    final String SQL_P = "SELECT post.id, post.author, post.title, post.text, " +
            "post.hashtags FROM post LEFT JOIN comment ON post.id = comment.post_id";
    final String SQL = "SELECT post.id, comment.id as c_id, comment.author, comment.text " +
            "FROM comment, post WHERE post.id = comment.post_id";
    private static ConnectionProvider connectionProvider;

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

    public List<Comment> getCommentList() throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement(SQL);
        ResultSet result = preparedStatement.executeQuery();
        Map<Integer, Comment> commentMap = new HashMap<>();

        while (result.next()) {
            int postId = result.getInt("id");
            if (!commentMap.containsKey(postId)) {
                Comment comment = new Comment(
                        result.getInt("c_id"),
                        result.getString("author"),
                        result.getString("text")
                );
                commentMap.put(postId, comment);
            }
        }
        return new ArrayList<>(commentMap.values());
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
}
