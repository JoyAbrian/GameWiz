package com.ruukaze.gamewiz.fragments;

import static com.ruukaze.gamewiz.databaseUtils.DBDataSource.getCommunities;
import static com.ruukaze.gamewiz.databaseUtils.DBDataSource.getUsers;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
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
import com.ruukaze.gamewiz.apiService.GameDataCallback;
import com.ruukaze.gamewiz.databaseUtils.DBDataSource;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import pl.droidsonroids.gif.GifImageView;

public class DiscoverFragment extends Fragment {
    private NestedScrollView nested_scroll_view;
    private GifImageView loading_screen;
    private ImageView toggle_search;
    private ImageView eco_friendly_games_image;
    private TextView eco_friendly_games_title;
    private TextView eco_friendly_games_date;
    private RecyclerView rv_featured_games;
    private RecyclerView rv_users;
    private RecyclerView rv_communities;
    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.myLooper());

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

        nested_scroll_view = view.findViewById(R.id.nested_scroll_view);
        loading_screen = view.findViewById(R.id.loading_screen);
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

        nested_scroll_view.setVisibility(View.GONE);
        loading_screen.setVisibility(View.VISIBLE);
        executor.execute(() -> {
            // Eco-Friendly Games
            DataSource.getEconestGames(new GameDataCallback() {
                @Override
                public void onSuccess(ArrayList<Game> games) {
                    Game game = games.get(0);
                    if (game.getCover() != null) {
                        Picasso.get().load("https://images.igdb.com/igdb/image/upload/t_cover_big/" + game.getCover().getImage_id() + ".jpg").into(eco_friendly_games_image);
                    }
                    eco_friendly_games_title.setText(game.getName());
                    eco_friendly_games_date.setText(game.getRelease_dates().get(0).getHuman());
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

            // Featured Games
            rv_featured_games.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            DataSource.getTopGames(new GameDataCallback() {
                @Override
                public void onSuccess(ArrayList<Game> games) {
                    rv_featured_games.setAdapter(new GameGridAdapter(games));
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

            // Featured Users
            rv_users.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            rv_users.setAdapter(new UserAdapter(getUsers()));

            // Featured Communities
            rv_communities.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            rv_communities.setAdapter(new CommunityDiscoverAdapter(getCommunities(), getContext()));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            handler.post(() -> {
                loading_screen.setVisibility(View.GONE);
                nested_scroll_view.setVisibility(View.VISIBLE);
            });
        });

        return view;
    }
}