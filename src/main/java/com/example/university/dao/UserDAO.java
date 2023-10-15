package com.example.university.dao;

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

    public User getUser(String username, String password) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.
                getConnection().prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet result = preparedStatement.executeQuery();
        boolean hasFirst = result.next();
        if (hasFirst) {
            return new User(
                    result.getInt("id"),
                    result.getString("username"),
                    null,
                    result.getString("name"),
                    result.getString("lastname"),
                    null,
                    null,
                    null,
                    null,
                    result.getString("role")
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
                    null,
                    result.getString("role")
            );
            usersList.add(user);
        }
        return usersList;
    }
}
