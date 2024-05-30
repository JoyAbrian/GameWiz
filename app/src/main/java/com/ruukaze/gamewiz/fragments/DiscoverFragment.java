package com.ruukaze.gamewiz.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.SearchActivity;
import com.ruukaze.gamewiz.adapter.GameGridAdapter;
import com.ruukaze.gamewiz.adapter.UserAdapter;
import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Game;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DiscoverFragment extends Fragment {
    private ImageView toggle_search;
    private RecyclerView rv_featured_games;
    private RecyclerView rv_users;
    private DatabaseHelper dbHelper;

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
        rv_users = view.findViewById(R.id.rv_users);
        toggle_search = view.findViewById(R.id.toggle_search);

        dbHelper = new DatabaseHelper(getContext());

        toggle_search.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        });

        rv_featured_games.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        fetchData();

        rv_users.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_users.setAdapter(new UserAdapter(getUsers()));

        return view;
    }

    private void fetchData() {
        Retrofit retrofit = ApiClient.getClient();
        ApiService apiService = retrofit.create(ApiService.class);

        String fields = "name, cover.*, release_dates.*";
        String name = "FIFA 23";
        int limit = 10;

        // Fetch Featured Games
        Call<ArrayList<Game>> call = apiService.searchByNameGames(fields, name, limit);
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

    private ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM users ORDER BY id DESC LIMIT 15", null);
        if (cursor.moveToFirst()) {
            do {
                // Get user data
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                String dateOfRegister = cursor.getString(cursor.getColumnIndexOrThrow("dateOfRegister"));
                int avatar = cursor.getInt(cursor.getColumnIndexOrThrow("avatar"));
                int community_id = cursor.getInt(cursor.getColumnIndexOrThrow("community_id"));
                String fullname = cursor.getString(cursor.getColumnIndexOrThrow("fullname"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));

                users.add(new User(id, username, dateOfRegister, avatar, community_id, fullname, email, password));
            } while (cursor.moveToNext());
        }
        return users;
    }
}