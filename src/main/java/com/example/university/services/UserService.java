package com.example.university.services;

import com.example.university.entity.User;
import com.example.university.utils.ConnectionProvider;
import com.example.university.utils.PasswordCrypto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class UserService {
    //language=sql
    private static String INSERT_QUERY = "INSERT INTO users (password_h, username, name, lastname) VALUES(?, ?, ?, ?)";
    //language=sql
    private static String SELECT_QUERY = "SELECT * FROM users WHERE username = ?";
    private Connection connection;
    public UserService(Connection connection) {
        this.connection = connection;
    }

    public boolean registerUser(User user, String password) throws SQLException {
        byte[] passwordHash = PasswordCrypto.hashPassword(password);
        String encodedPassword = PasswordCrypto.encodePassword(passwordHash);
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        statement.setString(1, encodedPassword);
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getName());
        statement.setString(4, user.getLastname());
        return statement.executeUpdate() > 0;
    }

    public boolean authUser(String username, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String passwordHash = resultSet.getString("password_h");
            byte[] passwordDecoded = PasswordCrypto.decodePassword(passwordHash);
            byte[] insertedPassword = PasswordCrypto.hashPassword(password);
            return Arrays.equals(passwordDecoded, insertedPassword);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService(ConnectionProvider.getConn().getConnection());
        String password = "26042004";
        String name = "Regina";
        String lastname = "Ivanova";
        String usernameA = "pchela_medovayaa";
        User user = new User(usernameA, name, lastname);
        try {
            boolean regRes = userService.registerUser(user, password);
            boolean authRes = userService.authUser(usernameA, password);
            System.out.println("registration: " + regRes);
            System.out.println("autentification: " + authRes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
