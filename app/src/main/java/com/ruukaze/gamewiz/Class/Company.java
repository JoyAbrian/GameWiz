package com.ruukaze.gamewiz.Class;

import java.util.List;

public class Company {
    private int id;
    private int country;
    private String description;
    private List<Integer> developed;
    private int logo;
    private String name;
    private List<Integer> published;
    private int start_date;
    private List<Integer> websites;

    public Company(int id, int country, String description, List<Integer> developed, int logo, String name, List<Integer> published, int start_date, List<Integer> websites) {
        this.id = id;
        this.country = country;
        this.description = description;
        this.developed = developed;
        this.logo = logo;
        this.name = name;
        this.published = published;
        this.start_date = start_date;
        this.websites = websites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getDeveloped() {
        return developed;
    }

    public void setDeveloped(List<Integer> developed) {
        this.developed = developed;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPublished() {
        return published;
    }

    public void setPublished(List<Integer> published) {
        this.published = published;
    }

    public int getStart_date() {
        return start_date;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public List<Integer> getWebsites() {
        return websites;
    }

    public void setWebsites(List<Integer> websites) {
        this.websites = websites;
    }
}
