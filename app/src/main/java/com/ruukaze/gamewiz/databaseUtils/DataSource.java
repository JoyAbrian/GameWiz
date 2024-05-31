package com.ruukaze.gamewiz.databaseUtils;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.adapter.GameGridAdapter;
import com.ruukaze.gamewiz.adapter.GameSearchAdapter;
import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.models.Game;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataSource {
    private static final Retrofit retrofit = ApiClient.getClient();
    private static final ApiService apiService = retrofit.create(ApiService.class);

    public static void getGamesByName(RecyclerView searchResults, String name) {
        String fields = "name, cover.*;";
        int limit = 10;

        Call<ArrayList<Game>> call = apiService.searchByNameGamesSimilarity(fields, name, limit);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    searchResults.setAdapter(new GameSearchAdapter(games));
                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }

    public static void getEconestGames(ImageView eco_friendly_games_image, TextView eco_friendly_games_title, TextView eco_friendly_games_date) {
        String bodyString = "fields name, screenshots.*, release_dates.*; where id = 204554;";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getTopGames(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    Picasso.get().load("https://images.igdb.com/igdb/image/upload/t_screenshot_big/" + games.get(0).getScreenshots().get(0).getImage_id() + ".jpg").into(eco_friendly_games_image);
                    eco_friendly_games_title.setText(games.get(0).getName());
                    eco_friendly_games_date.setText(games.get(0).getRelease_dates().get(0).getHuman());

                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }

    public static void getTopGames(RecyclerView searchResults) {
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
                    ArrayList<Game> games = response.body();
                    searchResults.setAdapter(new GameGridAdapter(games));
                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                    }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }
}
