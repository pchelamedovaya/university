package com.example.university.services;

import com.example.university.entity.Advt;
import com.example.university.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdvtService {
    private static String INSERT_QUERY = "INSERT INTO advt (title, format, time, url, nameAuthor, lastnameAuthor, message) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private Connection connection;

    public AdvtService(Connection connection) {
        this.connection = connection;

    }

    public boolean AddAdvt(Advt advt) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
        statement.setString(1, advt.getTitle());
        statement.setString(2, advt.getFormat());
        statement.setString(3, advt.getTime());
        statement.setString(4, advt.getUrl());
        statement.setString(5, advt.getNameAuthor());
        statement.setString(6, advt.getLastnameAuthor());
        statement.setString(7, advt.getMessage());
        return statement.executeUpdate() > 0;
    }

    public static void main(String[] args) {
        AdvtService advtService = new AdvtService(ConnectionProvider.getConn().getConnection());
        String title = "Title";
        String name = "Name";
        String lastname = "Lastname";
        String message = "Message";
        String format = "Distantly";
        String time = "Monday, Tuesday from 12:00";
        String url = "@pchela_medovayaa";

        Advt advt = new Advt(title, format, time, url, name, lastname, message);

        try {
            boolean addRes = advtService.AddAdvt(advt);
            System.out.println("addAdvt: " + addRes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
