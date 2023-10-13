package com.example.university.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionProvider {
    private static ConnectionProvider conn;
    private static Connection connection;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/university";
    private static final String USER = "postgres";
    private static final String PASS = "26042004";

    public static ConnectionProvider getConn() {
        if (conn == null) {
            conn = new ConnectionProvider();
        }
        return conn;
    }

    public Connection getConnection() {
        return connection;
    }

    private ConnectionProvider() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
