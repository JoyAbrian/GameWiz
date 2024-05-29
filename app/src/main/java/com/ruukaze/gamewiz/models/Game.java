package com.ruukaze.gamewiz.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int id;
    private float aggregated_rating;
    private Cover cover;
    private ArrayList<InvolvedCompany> involved_companies;
    private String name;
    private ArrayList<Platform> platforms;
    private ArrayList<ReleaseDate> release_dates;
    private ArrayList<Cover> screenshots;
    private ArrayList<Game> similar_games;
    private String summary;

    public Game(int id, float aggregated_rating, Cover cover, ArrayList<InvolvedCompany> involved_companies, String name, ArrayList<Platform> platforms, ArrayList<ReleaseDate> release_dates, ArrayList<Cover> screenshots, ArrayList<Game> similar_games, String summary) {
        this.id = id;
        this.aggregated_rating = aggregated_rating;
        this.cover = cover;
        this.involved_companies = involved_companies;
        this.name = name;
        this.platforms = platforms;
        this.release_dates = release_dates;
        this.screenshots = screenshots;
        this.similar_games = similar_games;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAggregated_rating() {
        return aggregated_rating;
    }

    public void setAggregated_rating(float aggregated_rating) {
        this.aggregated_rating = aggregated_rating;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public ArrayList<InvolvedCompany> getInvolved_companies() {
        return involved_companies;
    }

    public void setInvolved_companies(ArrayList<InvolvedCompany> involved_companies) {
        this.involved_companies = involved_companies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<Platform> platforms) {
        this.platforms = platforms;
    }

    public ArrayList<ReleaseDate> getRelease_dates() {
        return release_dates;
    }

    public void setRelease_dates(ArrayList<ReleaseDate> release_dates) {
        this.release_dates = release_dates;
    }

    public ArrayList<Cover> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(ArrayList<Cover> screenshots) {
        this.screenshots = screenshots;
    }

    public ArrayList<Game> getSimilar_games() {
        return similar_games;
    }

    public void setSimilar_games(ArrayList<Game> similar_games) {
        this.similar_games = similar_games;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}