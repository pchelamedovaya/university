package com.example.university.dao;

import com.example.university.entity.Comment;
import com.example.university.entity.Post;
import com.example.university.entity.User;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    //language=sql
    final String SQL = "SELECT comment.id as c_id, comment.author, comment.text " +
            "FROM comment WHERE comment.post_id = ?";
    private final String SELECT_INFO = "SELECT name FROM users WHERE username = ?";


    private static ConnectionProvider connectionProvider;

    public CommentDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<Comment> getCommentList(int postId) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement(SQL);
        preparedStatement.setInt(1, postId);
        ResultSet result = preparedStatement.executeQuery();
        List<Comment> commentList = new ArrayList<>();
        while (result.next()) {
            Comment comment = new Comment(
                    result.getInt("c_id"),
                    result.getString("author"),
                    result.getString("text")
            );
            commentList.add(comment);
        }
        return commentList;
    }

    public Comment getDetail(int id) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM post WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        boolean hasFirst = result.next();
        if (hasFirst) {
            return new Comment(
                    result.getInt("id"),
                    result.getString("author"),
                    result.getString("text")
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
