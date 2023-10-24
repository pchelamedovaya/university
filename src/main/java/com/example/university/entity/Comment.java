package com.example.university.entity;

public class Comment {
    private Integer id;
    private String author;
    private String text;
    private Post post;
    private int postId;

    public Comment(Integer id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    public Comment(int podtId, String author, String text) {
        this.postId = podtId;
        this.id = null;
        this.author = author;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}