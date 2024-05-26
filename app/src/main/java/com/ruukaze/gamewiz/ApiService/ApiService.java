package com.ruukaze.gamewiz.ApiService;

import com.ruukaze.gamewiz.Class.Company;
import com.ruukaze.gamewiz.Class.Game;
import com.ruukaze.gamewiz.Class.Genre;
import com.ruukaze.gamewiz.Class.Platform;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {
    @Headers({
            "Accept: application/json",
            "Content-Type: text/plain"
    })
    @GET("/games")
    Call<List<Game>> getGames();

    @Headers({
            "Accept: application/json",
            "Content-Type: text/plain"
    })
    @GET("/companies")
    Call<List<Company>> getCompanies();

    @Headers({
            "Accept: application/json",
            "Content-Type: text/plain"
    })
    @GET("/genres")
    Call<List<Genre>> getGenres();

    @Headers({
            "Accept: application/json",
            "Content-Type: text/plain"
    })
    @GET("/platforms")
    Call<List<Platform>> getPlatforms();
}