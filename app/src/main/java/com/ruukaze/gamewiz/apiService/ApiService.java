package com.ruukaze.gamewiz.apiService;

import com.ruukaze.gamewiz.models.Game;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("games")
    Call<ArrayList<Game>> getFeaturedGames(@Query("fields") String fields, @Query("where") String where, @Query("limit") int limit);
}