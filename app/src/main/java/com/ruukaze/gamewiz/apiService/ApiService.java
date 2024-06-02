package com.ruukaze.gamewiz.apiService;

import com.ruukaze.gamewiz.models.Game;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("games")
    Call<ArrayList<Game>> searchByNameGamesSimilarity(@Query("fields") String fields, @Query("search") String name, @Query("limit") int limit);

    @POST("games")
    Call<ArrayList<Game>> getTopGames(@Body RequestBody body);

    @POST("games")
    Call<ArrayList<Game>> getGameDetails(@Body RequestBody body);

    @POST("games")
    Call<ArrayList<Game>> getGameSummary(@Body RequestBody body);

    @POST("games")
    Call<ArrayList<Game>> getGameScreenshots(@Body RequestBody body);
}