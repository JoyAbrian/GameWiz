package com.ruukaze.gamewiz.models;

public class User {
    private int id;
    private String username;
    private String dateOfRegister;
    private int avatar;
    private int community_id;
    private String fullname;
    private String email;
    private String password;

    public User(int id, String username, String dateOfRegister, int avatar, int community_id, String fullname, String email, String password) {
        this.id = id;
        this.username = username;
        this.dateOfRegister = dateOfRegister;
        this.avatar = avatar;
        this.community_id = community_id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateOfRegister() {
        return dateOfRegister;
    }

    public void setDateOfRegister(String dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
