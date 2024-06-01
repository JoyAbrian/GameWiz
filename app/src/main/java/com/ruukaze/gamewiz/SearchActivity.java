package com.ruukaze.gamewiz;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.adapter.GameGridAdapter;
import com.ruukaze.gamewiz.adapter.GameSearchAdapter;
import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.apiService.DataCallback;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.models.Game;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchActivity extends AppCompatActivity {
    private EditText search_games;
    private ImageView toggle_back;
    private RecyclerView searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search_games = findViewById(R.id.search_games);
        toggle_back = findViewById(R.id.toggle_back);
        searchResults = findViewById(R.id.searchResults);
        searchResults.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        toggle_back.setOnClickListener(v -> finish());

        showSearchResults("");
        search_games.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showSearchResults(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });
    }

    private void showSearchResults(String querySearch) {
        DataSource.getGamesByName(querySearch, new DataCallback() {
            @Override
            public void onSuccess(ArrayList<Game> games) {
                searchResults.setAdapter(new GameSearchAdapter(games));
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}