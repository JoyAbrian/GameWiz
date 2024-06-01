package com.ruukaze.gamewiz;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.adapter.GameSearchAdapter;
import com.ruukaze.gamewiz.apiService.GameDataCallback;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.models.Game;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import pl.droidsonroids.gif.GifImageView;

public class SearchActivity extends AppCompatActivity {
    private GifImageView loading_screen;
    private EditText search_games;
    private ImageView toggle_back;
    private RecyclerView searchResults;
    private TextView no_results;
    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_games = findViewById(R.id.search_games);
        toggle_back = findViewById(R.id.toggle_back);
        searchResults = findViewById(R.id.searchResults);
        loading_screen = findViewById(R.id.loading_screen);
        no_results = findViewById(R.id.no_results);

        searchResults.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        toggle_back.setOnClickListener(v -> finish());

        searchResults.setVisibility(View.GONE);
        loading_screen.setVisibility(View.VISIBLE);
        executor.execute(() -> {
            showSearchResults("");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            handler.post(() -> {
                searchResults.setVisibility(View.VISIBLE);
                loading_screen.setVisibility(View.GONE);
            });
        });
        search_games.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchResults.setVisibility(View.GONE);
                loading_screen.setVisibility(View.VISIBLE);
                executor.execute(() -> {
                    showSearchResults(s.toString());
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    handler.post(() -> {
                        searchResults.setVisibility(View.VISIBLE);
                        loading_screen.setVisibility(View.GONE);
                    });
                });
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });
    }

    private void showSearchResults(String querySearch) {
        DataSource.getGamesByName(querySearch, new GameDataCallback() {
            @Override
            public void onSuccess(ArrayList<Game> games) {
                searchResults.setAdapter(new GameSearchAdapter(games));
                if (games.isEmpty()) {
                    searchResults.setVisibility(View.GONE);
                    no_results.setVisibility(View.VISIBLE);
                } else {
                    searchResults.setVisibility(View.VISIBLE);
                    no_results.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}