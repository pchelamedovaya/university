package com.example.university.dao;

import com.example.university.entity.Faculty;
import com.example.university.entity.Speciality;
import com.example.university.utils.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacultyDAO {
    final String SQL = "SELECT faculty.id, faculty.nameFaculty, faculty.abbreviation, faculty.code, " +
            "faculty.phoneNumber, faculty.address, faculty.email, " +
            "speciality.id as s_id, speciality.specialityName, speciality.specialityCode, " +
            "speciality.curriculumCode, speciality.curriculumLink, speciality.description " +
            "FROM faculty LEFT JOIN speciality ON faculty.id = speciality.faculty_id";
    private static ConnectionProvider connectionProvider;

    public FacultyDAO(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public List<Faculty> getFacultyList() throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement(SQL);
        ResultSet result = preparedStatement.executeQuery();
        Map<Integer, Faculty> facultyMap = new HashMap<>();
        while (result.next()) {
            int facultyId = result.getInt("id");
            if (!facultyMap.containsKey(facultyId)) {
                Faculty faculty = new Faculty(
                        facultyId,
                        result.getString("nameFaculty"),
                        result.getString("abbreviation"),
                        result.getString("code"),
                        result.getString("phoneNumber"),
                        result.getString("address"),
                        result.getString("email")
                );
                facultyMap.put(facultyId, faculty);
            }
            Speciality speciality = new Speciality(
                    result.getInt("s_id"),
                    result.getString("specialityName"),
                    result.getString("specialityCode"),
                    result.getString("curriculumCode"),
                    result.getString("curriculumLink"),
                    result.getString("description")
            );
            facultyMap.get(facultyId).addSpeciality(speciality);
        }
        return new ArrayList<>(facultyMap.values());
    }

    public List<Faculty> getAllFaculty() throws SQLException {
        PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM faculty");
        ResultSet result = preparedStatement.executeQuery();
        List<Faculty> facultyList = new ArrayList<>();
        while (result.next()) {
            Faculty faculty = new Faculty(
                    result.getInt("id"),
                    result.getString("nameFaculty"),
                    result.getString("abbreviation"),
                    result.getString("code"),
                    result.getString("phoneNumber"),
                    result.getString("address"),
                    result.getString("email")
            );
            facultyList.add(faculty);
        }
        return facultyList;
    }
}
