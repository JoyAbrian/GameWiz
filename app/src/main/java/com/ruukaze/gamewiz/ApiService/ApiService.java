package com.ruukaze.gamewiz.ApiService;

import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: text/plain"
    })
    @GET("/games")
    Call<List<Game>> getGames();
}