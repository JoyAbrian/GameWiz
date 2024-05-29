package com.ruukaze.gamewiz.databaseUtils;

import android.util.Log;

import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.models.Company;
import com.ruukaze.gamewiz.models.Game;
import com.ruukaze.gamewiz.models.Genre;
import com.ruukaze.gamewiz.models.Platform;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {
    private static final String TAG = "DataSource";
    private static final String BASE_URL = "https://api.igdb.com/v4";

    private final List<Game> games = new ArrayList<>();

    public DataSource() {
        fetchDataFromApi();
    }

    private void fetchDataFromApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        // Fetch games
        apiService.getGames().enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    games.addAll(response.body());
                } else {
                    Log.e(TAG, "Failed to fetch games: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                Log.e(TAG, "Failed to fetch games: " + t.getMessage());
            }
        });
    }

    public List<Game> getGames() {
        return games;
    }
}
