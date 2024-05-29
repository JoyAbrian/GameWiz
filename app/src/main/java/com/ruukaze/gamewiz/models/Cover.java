package com.ruukaze.gamewiz.models;

public class Cover {
    private int id;
    private String image_id;

    public Cover(int id, String image_id) {
        this.id = id;
        this.image_id = image_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
}
