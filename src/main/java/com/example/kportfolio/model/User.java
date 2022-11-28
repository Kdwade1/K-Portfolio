package com.example.kportfolio.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String verificationCode;

    @Column
    private boolean enable;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<JPost> post;

    public User(User user) {
    }

    public User(long id, String name, String password, String email, String verificationCode, boolean enable,List<JPost> post) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.verificationCode = verificationCode;
        this.enable = enable;
        this.post=post;
    }


    public User(String name, String password, String email, String verificationCode, boolean enable,List<JPost>post) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.verificationCode = verificationCode;
        this.enable = enable;
        this.post = post;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<JPost> getPost() {
        return post;
    }

    public void setPost(List<JPost> post) {
        this.post = post;
    }
}
