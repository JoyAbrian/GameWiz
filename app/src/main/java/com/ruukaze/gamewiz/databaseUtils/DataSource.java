package com.ruukaze.gamewiz.databaseUtils;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.adapter.GameSearchAdapter;
import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.models.Game;

import java.util.ArrayList;

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

        Call<ArrayList<Game>> call = apiService.searchByNameGames(fields, name, limit);
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
}
