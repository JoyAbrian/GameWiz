package com.ruukaze.gamewiz.Class;

import java.util.List;

public class Game {
    private int id;
    private List<Integer> age_ratings;
    private float aggregated_rating;
    private int cover;
    private List<Integer> involved_companies;
    private String name;
    private List<Integer> platforms;
    private List<Integer> release_dates;
    private List<Integer> screenshots;
    private List<Integer> similar_games;
    private String summary;
    private List<Integer> videos;

    public Game(int id, List<Integer> age_ratings, float aggregated_rating, int cover, List<Integer> involved_companies, String name, List<Integer> platforms, List<Integer> release_dates, List<Integer> screenshots, List<Integer> similar_games, String summary, List<Integer> videos) {
        this.id = id;
        this.age_ratings = age_ratings;
        this.aggregated_rating = aggregated_rating;
        this.cover = cover;
        this.involved_companies = involved_companies;
        this.name = name;
        this.platforms = platforms;
        this.release_dates = release_dates;
        this.screenshots = screenshots;
        this.similar_games = similar_games;
        this.summary = summary;
        this.videos = videos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getAge_ratings() {
        return age_ratings;
    }

    public void setAge_ratings(List<Integer> age_ratings) {
        this.age_ratings = age_ratings;
    }

    public float getAggregated_rating() {
        return aggregated_rating;
    }

    public void setAggregated_rating(float aggregated_rating) {
        this.aggregated_rating = aggregated_rating;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public List<Integer> getInvolved_companies() {
        return involved_companies;
    }

    public void setInvolved_companies(List<Integer> involved_companies) {
        this.involved_companies = involved_companies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Integer> platforms) {
        this.platforms = platforms;
    }

    public List<Integer> getRelease_dates() {
        return release_dates;
    }

    public void setRelease_dates(List<Integer> release_dates) {
        this.release_dates = release_dates;
    }

    public List<Integer> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<Integer> screenshots) {
        this.screenshots = screenshots;
    }

    public List<Integer> getSimilar_games() {
        return similar_games;
    }

    public void setSimilar_games(List<Integer> similar_games) {
        this.similar_games = similar_games;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Integer> getVideos() {
        return videos;
    }

    public void setVideos(List<Integer> videos) {
        this.videos = videos;
    }
}
