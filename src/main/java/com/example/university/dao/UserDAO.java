package com.example.university.dao;

import com.example.university.entity.News;
import com.example.university.entity.User;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private ConnectionProvider connectionProvider;

    public UserDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public User getUser(int id) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.
                getConnection().prepareStatement("SELECT * FROM users WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        boolean hasFirst = result.next();
        if (hasFirst) {
            return new User(
                    result.getInt("id"),
                    result.getString("username"),
                    result.getString("name"),
                    result.getString("lastname")
            );
        } else {
            return null;
        }
    }

    public List<User> getAllUsers(int limit) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.
                getConnection().prepareStatement("SELECT * FROM users LIMIT ?");
        preparedStatement.setInt(1, limit);
        ResultSet result = preparedStatement.executeQuery();
        List<User> usersList = new ArrayList<>();
        while (result.next()) {
            User user = new User(
                    result.getInt("id"),
                    result.getString("username"),
                    null,
                    result.getString("name"),
                    result.getString("lastname"),
                    null,
                    null,
                    null,
                    null
            );
            usersList.add(user);
        }
        return usersList;
    }
}
