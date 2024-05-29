package com.ruukaze.gamewiz.models;

public class ReleaseDate {
    private int id;
    private String human;

    public ReleaseDate(int id, String human) {
        this.id = id;
        this.human = human;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHuman() {
        return human;
    }

    public void setHuman(String human) {
        this.human = human;
    }
}
