package com.example.university.entity;

import java.util.Date;
import java.util.Objects;

public class News {
    private Integer id;
    private Date date;
    private String title;
    private String category;

    private String shortdescription;
    private String content;
    private String url;

    public News(Integer id, java.sql.Date date, String title, String category, String shortdescription, String content, String url) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.category = category;
        this.shortdescription = shortdescription;
        this.content = content;
        this.url = url;
    }

    public News(Date date, String title, String category, String shortdescription, String content, String url) {
        this.id = null;
        this.date = date;
        this.title = title;
        this.category = category;
        this.shortdescription = shortdescription;
        this.content = content;
        this.url = url;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id) && Objects.equals(date, news.date) && Objects.equals(title, news.title) && Objects.equals(category, news.category) && Objects.equals(content, news.content) && Objects.equals(url, news.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, title, category, content, url);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
