package com.example.kportfolio.model;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    public JPost() {
    }

    public JPost(long id, String title, String post, User user) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.user = user;
    }

    public JPost(String title, String post, User user) {
        this.title = title;
        this.post = post;
        this.user = user;
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
}


