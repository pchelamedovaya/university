package com.example.university.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private Integer id;
    private String author;
    private String title;
    private String text;
    private String hashtags;
    private List<Comment> commentList;

    public List<Comment> getComments() {
        return commentList;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    public Post(Integer id, String author, String title, String text, String hashtags) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.text = text;
        this.hashtags = hashtags;
        this.commentList = new ArrayList<>();
    }

    public Post(String author, String title, String text, String hashtags) {
        this.id = null;
        this.author = author;
        this.title = title;
        this.text = text;
        this.hashtags = hashtags;
        this.commentList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
