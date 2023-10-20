package com.example.university.entity;

public class Advt {
    private Integer id;
    private String title;
    private String format;
    private String time;
    private String url;
    private String nameAuthor;
    private String lastnameAuthor;
    private String message;

    public Advt(String title, String format, String time, String url, String nameAuthor, String lastnameAuthor, String message) {
        this.title = title;
        this.format = format;
        this.time = time;
        this.url = url;
        this.nameAuthor = nameAuthor;
        this.lastnameAuthor = lastnameAuthor;
        this.message = message;
    }

    public Advt(Integer id, String title, String format, String time, String url, String nameAuthor, String lastnameAuthor, String message) {
        this.id = null;
        this.title = title;
        this.format = format;
        this.time = time;
        this.url = url;
        this.nameAuthor = nameAuthor;
        this.lastnameAuthor = lastnameAuthor;
        this.message = message;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getLastnameAuthor() {
        return lastnameAuthor;
    }

    public void setLastnameAuthor(String lastnameAuthor) {
        this.lastnameAuthor = lastnameAuthor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
