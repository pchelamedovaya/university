package com.example.university.dao;

import com.example.university.entity.Comment;
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
}
