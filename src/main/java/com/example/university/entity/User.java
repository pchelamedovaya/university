package com.example.university.entity;

public class User {
    private Integer id;
    private String username;
    private String password;
//    private String name;
//    private String role;
//    private String about;

//, String name, String role, String about
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
//        this.name = name;
//        this.role = role;
//        this.about = about;
    }

    public User(String username, String password) {
        this.id = null;
        this.username = username;
        this.password = password;
//        this.name = name;
//        this.role = role;
//        this.about = about;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getAbout() {
//        return about;
//    }
//
//    public void setAbout(String about) {
//        this.about = about;
//    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
