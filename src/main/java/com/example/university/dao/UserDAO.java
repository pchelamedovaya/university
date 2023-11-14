package com.example.university.dao;

import com.example.university.entity.User;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final String UPDATE = "UPDATE users SET name = ?, lastname = ?, gender = ?, institute = ?, curGroup = ?, bio = ?, username = ? WHERE username = ?";
    private final String SELECT_ALL = "SELECT * FROM users LIMIT ?";
    private final String SELECT_USERNAME_PATTERN = "SELECT * FROM users WHERE username LIKE ?";
    private final String SELECT_NAME_PATTERN = "SELECT * FROM users WHERE name LIKE ?";
    private final String SELECT_LASTNAME_PATTERN = "SELECT * FROM users WHERE lastname LIKE ?";
    private final String SELECT_INFO = "SELECT name, lastname, bio, gender, institute, curGroup, username FROM users WHERE username = ?";
    private ConnectionProvider connectionProvider;

    public UserDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<User> getUsersByPattern(String pattern, String searchField) {
        System.out.println("PATTERN: " + pattern);
        try {
            PreparedStatement preparedStatement = this.connectionProvider
                    .getConnection().prepareStatement(getSelectPattern(searchField));
            preparedStatement.setString(1, "%" + pattern + "%");
            ResultSet result = preparedStatement.executeQuery();
            List<User> usersList = new ArrayList<>();
            while (result.next()) {
                User user = new User(
                        result.getInt("id"),
                        result.getString("username"),
                        result.getString("name"),
                        result.getString("lastname")
                );
                usersList.add(user);
            }
            System.out.println("FOUND USERS:" + usersList);
            return usersList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getSelectPattern(String searchField) {
        switch (searchField) {
            case "username":
                return SELECT_USERNAME_PATTERN;
            case "name":
                return SELECT_NAME_PATTERN;
            case "lastname":
                return SELECT_LASTNAME_PATTERN;
            default:
                throw new IllegalArgumentException("Invalid searchField");
        }
    }

    public List<User> getAllUsers(int limit) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.
                getConnection().prepareStatement(SELECT_ALL);
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

    public void ChangingUserInfo(String username, String name, String lastname, String gender, String institute, String curGroup, String bio) {
        try {
            PreparedStatement preparedStatement = this.connectionProvider.
                    getConnection().prepareStatement(UPDATE);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, institute);
            preparedStatement.setString(5, curGroup);
            preparedStatement.setString(6, bio);
            preparedStatement.setString(7, username);
            preparedStatement.setString(8, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
                user.setLastname(result.getString("lastname"));
                user.setBio(result.getString("bio"));
                user.setGender(result.getString("gender"));
                user.setInstitute(result.getString("institute"));
                user.setGroup(result.getString("curGroup"));
                user.setUsername(result.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
