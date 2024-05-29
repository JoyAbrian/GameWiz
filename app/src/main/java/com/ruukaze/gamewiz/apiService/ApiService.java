package com.ruukaze.gamewiz.apiService;

import com.ruukaze.gamewiz.models.Company;
import com.ruukaze.gamewiz.models.Game;
import com.ruukaze.gamewiz.models.Genre;
import com.ruukaze.gamewiz.models.Platform;

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
}