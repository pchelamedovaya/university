package com.example.university.dao;

import com.example.university.entity.Speciality;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialityDAO {
    private static ConnectionProvider connectionProvider;

    public SpecialityDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<Speciality> getALlSpecialityList() throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM speciality");
        ResultSet result = preparedStatement.executeQuery();
        List<Speciality> specialityList = new ArrayList<>();
        while (result.next()) {
            Speciality speciality = new Speciality(
                    result.getInt("id"),
                    result.getString("specialityName"),
                    result.getString("specialityCode"),
                    result.getString("curriculumCode"),
                    result.getString("description"),
                    result.getString("curriculumLink")
            );
            specialityList.add(speciality);
        }
        return specialityList;
    }
}
