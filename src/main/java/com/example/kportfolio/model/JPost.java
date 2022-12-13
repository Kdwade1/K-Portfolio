package com.example.kportfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name="Jpost")
public class JPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String post;

    @Column()
    private String picture;

    @Column(nullable= false)
    private LocalDateTime dateTime= LocalDateTime.now();

    public JPost(long id, String title, String post, String picture, LocalDateTime dateTime, User user) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.picture = picture;
        this.dateTime = dateTime;
        this.user = user;
    }

    public JPost(String title, String post, String picture, LocalDateTime dateTime, User user) {
        this.title = title;
        this.post = post;
        this.picture = picture;
        this.dateTime = dateTime;
        this.user = user;
    }



    @ManyToOne
    @JoinColumn(name = "userId")
    User user;


    public JPost() {
    }






    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}


