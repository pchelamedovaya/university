package com.example.university.entity;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String gender;
    private String institute;
    private String group;
    private String about;

    public User(Integer id, String username, String password, String name, String lastname, String gender, String institute, String group, String about) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.institute = institute;
        this.group = group;
        this.about = about;
    }

    public User(String username, String name, String lastname) {
        this.id = null;
        this.username = username;
        this.password = null;
        this.name = name;
        this.lastname = lastname;
        this.gender = null;
        this.institute = null;
        this.group = null;
        this.about = null;
    }

    public User(Integer id, String username, String name, String lastname) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
