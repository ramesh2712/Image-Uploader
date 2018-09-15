package com.upgrad.ImageHoster.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment {

    // These annotations auto-increments the id column for us whenever
    // a new Tag is stored into the database
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Image image ;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Comment() { }

    public Comment(String text, Image image, User user) {
        this.text = text;
        this.image = image;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
