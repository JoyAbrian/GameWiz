package com.ruukaze.gamewiz.DatabaseUtils;

import android.util.Log;

import com.ruukaze.gamewiz.ApiService.ApiService;
import com.ruukaze.gamewiz.Class.Company;
import com.ruukaze.gamewiz.Class.Game;
import com.ruukaze.gamewiz.Class.Genre;
import com.ruukaze.gamewiz.Class.Platform;

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
    private final List<Company> companies = new ArrayList<>();
    private final List<Genre> genres = new ArrayList<>();
    private final List<Platform> platforms = new ArrayList<>();

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

        // Fetch companies
        apiService.getCompanies().enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    companies.addAll(response.body());
                } else {
                    Log.e(TAG, "Failed to fetch companies: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable t) {
                Log.e(TAG, "Failed to fetch companies: " + t.getMessage());
            }
        });

        // Fetch genres
        apiService.getGenres().enqueue(new Callback<List<Genre>>() {
            @Override
            public void onResponse(Call<List<Genre>> call, Response<List<Genre>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    genres.addAll(response.body());
                } else {
                    Log.e(TAG, "Failed to fetch genres: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Genre>> call, Throwable t) {
                Log.e(TAG, "Failed to fetch genres: " + t.getMessage());
            }
        });

        // Fetch platforms
        apiService.getPlatforms().enqueue(new Callback<List<Platform>>() {
            @Override
            public void onResponse(Call<List<Platform>> call, Response<List<Platform>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    platforms.addAll(response.body());
                } else {
                    Log.e(TAG, "Failed to fetch platforms: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Platform>> call, Throwable t) {
                Log.e(TAG, "Failed to fetch platforms: " + t.getMessage());
            }
        });
    }

    public List<Game> getGames() {
        return games;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }
}
