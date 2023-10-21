package com.example.university.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private Integer id;
    private String nameFaculty;
    private String abbreviation;
    private String code;
    private String phoneNumber;
    private String address;
    private String email;
    private List<Speciality> specialityList;

    public Faculty(Integer id, String nameFaculty, String abbreviation, String code, String phoneNumber, String address, String email) {
        this.id = id;
        this.nameFaculty = nameFaculty;
        this.abbreviation = abbreviation;
        this.code = code;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.specialityList = new ArrayList<>();
    }

    public void addSpeciality(Speciality speciality) {
        specialityList.add(speciality);
    }

    public List<Speciality> getSpecialities() {
        return specialityList;
    }

    public Faculty(String nameFaculty, String abbreviation, String code, String phoneNumber, String address, String email) {
        this.id = null;
        this.nameFaculty = nameFaculty;
        this.abbreviation = abbreviation;
        this.code = code;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.specialityList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(String nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Speciality> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(List<Speciality> specialityList) {
        this.specialityList = specialityList;
    }
}
