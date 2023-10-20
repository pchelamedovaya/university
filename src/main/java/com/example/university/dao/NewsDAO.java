package com.example.university.dao;

import com.example.university.entity.News;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDAO {
    private static ConnectionProvider connectionProvider;

    public NewsDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<News> getNewsList(int limit) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM news LIMIT ?");
        preparedStatement.setInt(1, limit);
        ResultSet result = preparedStatement.executeQuery();
        List<News> newsList = new ArrayList<>();
        while (result.next()) {
            News news = new News(
                    result.getInt("id"),
                    result.getDate("date"),
                    result.getString("title"),
                    result.getString("category"),
                    result.getString("shortdescription"),
                    result.getString("content"),
                    result.getString("url")
            );
            newsList.add(news);
        }
        return newsList;
    }

    public News getDetail(int id) throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM news WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        boolean hasFirst = result.next();
        if (hasFirst) {
            return new News(
                    result.getInt("id"),
                    result.getDate("date"),
                    result.getString("title"),
                    result.getString("category"),
                    result.getString("shortDescription"),
                    result.getString("content"),
                    result.getString("url")
            );
        } else {
            return null;
        }
    }
}
