package com.ruukaze.gamewiz.models;

public class Platform {
    private int id;
    private String name;
    private int platform_logo;

    public Platform(int id, String name, int platform_logo) {
        this.id = id;
        this.name = name;
        this.platform_logo = platform_logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlatform_logo() {
        return platform_logo;
    }

    public void setPlatform_logo(int platform_logo) {
        this.platform_logo = platform_logo;
    }
}
