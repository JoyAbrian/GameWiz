package com.ruukaze.gamewiz.models;

public class Post {
    private int id;
    private int community_id;
    private int user_id;
    private String post;
    private String image;

    public Post(int id, int community_id, int user_id, String post, String image) {
        this.id = id;
        this.community_id = community_id;
        this.user_id = user_id;
        this.post = post;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
