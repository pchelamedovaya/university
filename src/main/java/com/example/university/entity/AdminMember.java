package com.example.university.entity;

public class AdminMember {
    private Integer id;
    private String url;
    private String name;
    private String lastname;
    private String jobTitle;
    private String bio;

    public AdminMember(String url, String name, String lastname, String jobTitle, String bio) {
        this.id = null;
        this.url = url;
        this.name = name;
        this.lastname = lastname;
        this.jobTitle = jobTitle;
        this.bio = bio;
    }

    public AdminMember(Integer id, String url, String name, String lastname, String jobTitle, String bio) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.lastname = lastname;
        this.jobTitle = jobTitle;
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
