package com.ruukaze.gamewiz.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.adapter.GameGridAdapter;
import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.models.Game;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DiscoverFragment extends Fragment {
    private RecyclerView rv_featured_games;
    private GameGridAdapter gameGridAdapter;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    public static DiscoverFragment newInstance() {
        return new DiscoverFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        rv_featured_games = view.findViewById(R.id.rv_featured_games);
        rv_featured_games.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        fetchData();

        return view;
    }

    private void fetchData() {
        Retrofit retrofit = ApiClient.getClient();
        ApiService apiService = retrofit.create(ApiService.class);

        String fields = "name, cover.*, release_dates.*";
        String where = "where name = 'FIFA 23'";
        int limit = 10;

        // Fetch Featured Games
        Call<ArrayList<Game>> call = apiService.getFeaturedGames(fields, where, limit);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    rv_featured_games.setAdapter(new GameGridAdapter(games));
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