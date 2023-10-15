package com.example.university.services;

import com.example.university.entity.User;
import com.example.university.utils.ConnectionProvider;
import com.example.university.utils.PasswordCrypto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService extends UserServiceSimple {

    public UserService(Connection connection) {
        super(connection);
    }

    @Override
    public boolean registerUser(User user, String password) throws SQLException {
        byte[] passwordHash = PasswordCrypto.hashPassword(password);
        String encodedPassword = PasswordCrypto.encodePassword(passwordHash);
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY_A);
        statement.setString(1, encodedPassword);
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getName());
        statement.setString(4, user.getLastname());
        statement.setString(5, user.getRole());
        return statement.executeUpdate() > 0;
    }
//    /*
    public static void main(String[] args) {
        UserService userService = new UserService(ConnectionProvider.getConn().getConnection());
        UserServiceSimple userServiceSimple = new UserServiceSimple(ConnectionProvider.getConn().getConnection());
        String password = "26042004";
        String name = "Regina";
        String lastname = "Ivanova";
        String usernameA = "pchela_medovayaa";
        String usernameS = "pchela_medovayaa_simple";
        String roleA = "admin";

        User user = new User(usernameA, name, lastname, roleA);
        User userSimple = new User(usernameS, name, lastname);

        try {
            boolean regRes = userService.registerUser(user, password);
            boolean regResSimple = userServiceSimple.registerUser(userSimple, password);
            System.out.println("registration: " + regRes + ", " + regResSimple);

            boolean authRes = userService.authUser(usernameA, password);
            boolean authResSimple = userService.authUser(usernameS, password);
            System.out.println("autentification: " + authRes + ", " + authResSimple);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    */
}
