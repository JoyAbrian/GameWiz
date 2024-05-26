package com.ruukaze.gamewiz.models;

public class Community {
    private int id;
    private String name;
    private String description;
    private int icon;
    private int leader_id;

    public Community(int id, String name, String description, int icon, int leader_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.leader_id = leader_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(int leader_id) {
        this.leader_id = leader_id;
    }
}
