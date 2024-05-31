package com.ruukaze.gamewiz.fragments;

import static com.ruukaze.gamewiz.databaseUtils.DBDataSource.getCommunities;
import static com.ruukaze.gamewiz.databaseUtils.DBDataSource.getUsers;

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
import android.widget.TextView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.SearchActivity;
import com.ruukaze.gamewiz.adapter.CommunityDiscoverAdapter;
import com.ruukaze.gamewiz.adapter.GameGridAdapter;
import com.ruukaze.gamewiz.adapter.UserAdapter;
import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.databaseUtils.DBDataSource;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Community;
import com.ruukaze.gamewiz.models.Game;
import com.ruukaze.gamewiz.models.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DiscoverFragment extends Fragment {
    private ImageView toggle_search;
    private ImageView eco_friendly_games_image;
    private TextView eco_friendly_games_title;
    private TextView eco_friendly_games_date;
    private RecyclerView rv_featured_games;
    private RecyclerView rv_users;
    private RecyclerView rv_communities;
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

        eco_friendly_games_image = view.findViewById(R.id.eco_friendly_games_image);
        eco_friendly_games_title = view.findViewById(R.id.eco_friendly_games_title);
        eco_friendly_games_date = view.findViewById(R.id.eco_friendly_games_date);

        rv_featured_games = view.findViewById(R.id.rv_featured_games);
        rv_users = view.findViewById(R.id.rv_users);
        rv_communities = view.findViewById(R.id.rv_communities);

        toggle_search = view.findViewById(R.id.toggle_search);

        DBDataSource.initialize(getContext());

        toggle_search.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        });

        // Eco-Friendly Games
        DataSource.getEconestGames(eco_friendly_games_image, eco_friendly_games_title, eco_friendly_games_date);

        // Featured Games
        rv_featured_games.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        DataSource.getTopGames(rv_featured_games);

        // Featured Users
        rv_users.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_users.setAdapter(new UserAdapter(getUsers()));

        // Featured Communities
        rv_communities.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_communities.setAdapter(new CommunityDiscoverAdapter(getCommunities(), getContext()));

        return view;
    }


}