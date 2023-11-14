package com.example.university.dao;

import com.example.university.entity.Advt;
import com.example.university.entity.User;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvtDAO {
    private static ConnectionProvider connectionProvider;
    private final String SELECT_INFO = "SELECT name, lastname FROM users WHERE username = ?";


    public AdvtDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public static List<Advt> getAdvtList(int limit) throws SQLException {
        PreparedStatement preparedStatement = connectionProvider.getConnection().prepareStatement("SELECT * FROM advt LIMIT ?");
        preparedStatement.setInt(1, limit);
        ResultSet result = preparedStatement.executeQuery();
        List<Advt> advtList = new ArrayList<>();
        while (result.next()) {
            Advt advt = new Advt(
                    result.getInt("id"),
                    result.getString("title"),
                    result.getString("format"),
                    result.getString("time"),
                    result.getString("url"),
                    result.getString("nameAuthor"),
                    result.getString("lastnameAuthor"),
                    result.getString("message")
            );
            advtList.add(advt);
        }
        return advtList;
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
                user.setUsername(result.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
