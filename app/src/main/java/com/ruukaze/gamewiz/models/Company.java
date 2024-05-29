package com.ruukaze.gamewiz.models;

import java.util.ArrayList;

public class Company {
    private int id;
    private String description;
    private ArrayList<Game> developed;
    private String name;
    private ArrayList<Game> published;

    public Company(int id, String description, ArrayList<Game> developed, String name, ArrayList<Game> published) {
        this.id = id;
        this.description = description;
        this.developed = developed;
        this.name = name;
        this.published = published;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Game> getDeveloped() {
        return developed;
    }

    public void setDeveloped(ArrayList<Game> developed) {
        this.developed = developed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Game> getPublished() {
        return published;
    }

    public void setPublished(ArrayList<Game> published) {
        this.published = published;
    }
}
