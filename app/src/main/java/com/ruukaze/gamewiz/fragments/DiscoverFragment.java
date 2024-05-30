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
import com.ruukaze.gamewiz.adapter.CommunityDiscoverAdapter;
import com.ruukaze.gamewiz.adapter.GameGridAdapter;
import com.ruukaze.gamewiz.adapter.UserAdapter;
import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Community;
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

        rv_featured_games = view.findViewById(R.id.rv_featured_games);
        rv_users = view.findViewById(R.id.rv_users);
        rv_communities = view.findViewById(R.id.rv_communities);

        toggle_search = view.findViewById(R.id.toggle_search);

        dbHelper = new DatabaseHelper(getContext());

        toggle_search.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        });

        rv_featured_games.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        DataSource.getFeaturedGames(rv_featured_games, "featured");

        rv_users.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_users.setAdapter(new UserAdapter(getUsers()));

        rv_communities.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_communities.setAdapter(new CommunityDiscoverAdapter(getCommunities(), getContext()));

        return view;
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

    private ArrayList<Community> getCommunities() {
        ArrayList<Community> communities = new ArrayList<>();
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM communities ORDER BY id DESC LIMIT 15", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                int icon = cursor.getInt(cursor.getColumnIndexOrThrow("icon"));
                int leader_id = cursor.getInt(cursor.getColumnIndexOrThrow("leader_id"));

                communities.add(new Community(id, name, description, icon, leader_id));
            } while (cursor.moveToNext());
        }
        return communities;
    }
}