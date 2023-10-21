package com.example.university.dao;

import com.example.university.entity.AdminMember;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMemberDAO {
    private static ConnectionProvider connectionProvider;

    public AdminMemberDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<AdminMember> getAdminMemberList() throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM admin_members");
        ResultSet result = preparedStatement.executeQuery();
        List<AdminMember> adminMemberList = new ArrayList<>();
        while (result.next()) {
            AdminMember member = new AdminMember(
                    result.getInt("id"),
                    result.getString("url"),
                    result.getString("name"),
                    result.getString("lastname"),
                    result.getString("jobTitle"),
                    result.getString("bio")
            );
            adminMemberList.add(member);
        }
        return adminMemberList;
    }
}
