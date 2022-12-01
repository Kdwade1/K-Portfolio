package com.example.kportfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

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
    @JsonFormat(pattern = "HH:mm:ss")
    private Time orderTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    @Column()
    private String picture;


    @ManyToOne
    @JoinColumn(name = "userId")
    User user;


    public JPost() {
    }




    public JPost(long id, String title, String post, User user, Time orderTime, Date orderDate, String picture) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.user = user;
        this.orderTime = orderTime;
        this.orderDate = orderDate;
        this.picture=picture;
    }

    public JPost(String title, String post, User user, Time orderTime, Date orderDate,String picture) {
        this.title = title;
        this.post = post;
        this.user = user;
        this.orderTime = orderTime;
        this.orderDate = orderDate;
        this.picture =picture;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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
}


