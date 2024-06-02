package com.ruukaze.gamewiz.databaseUtils;

import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.apiService.GameDataCallback;
import com.ruukaze.gamewiz.models.Game;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataSource {
    private static final Retrofit retrofit = ApiClient.getClient();
    private static final ApiService apiService = retrofit.create(ApiService.class);

    public static void getGamesByName(String name, GameDataCallback callback) {
        String bodyString = "search \"" + name + "\";" +
                "fields id, name, cover.*;" +
                "where version_parent = null & rating != null & cover != null & screenshots != null & release_dates != null;" +
                "limit 10;";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.searchByNameGamesSimilarity(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(new Exception("Failed to fetch games: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void getEconestGames(GameDataCallback callback) {
        String bodyString = "fields id, name, screenshots.*, release_dates.*; where id = 204554;";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getTopGames(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(new Exception("Failed to fetch games: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void getTopGames(GameDataCallback callback) {
        String bodyString = "fields name, cover.*, release_dates.*;" +
                " limit 10;" +
                " where version_parent = null & platforms = (48, 167)" +
                " & rating != null & rating_count > 100;" +
                " sort rating desc;";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getTopGames(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(new Exception("Failed to fetch games: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void getGamesDetails(int game_id, GameDataCallback callback) {
        String bodyString = "fields id, name, cover.*, screenshots.*, release_dates.*;" +
                "limit 1;" +
                "where id = " + game_id + ";";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getGameDetails(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(new Exception("Failed to fetch game details: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void getGamesSummary(int game_id, GameDataCallback callback) {
        String bodyString = "fields id, summary;" +
                "limit 1;" +
                "where id = " + game_id + ";";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getGameSummary(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(new Exception("Failed to fetch game summary: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public static void getGamesScreenshot(int game_id, GameDataCallback callback) {
        String bodyString = "fields screenshots.*;" +
                "limit 1;" +
                "where id = " + game_id + ";";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getGameScreenshots(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure(new Exception("Failed to fetch game screenshots: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}