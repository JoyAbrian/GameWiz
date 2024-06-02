package com.ruukaze.gamewiz.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.adapter.ScreenshotAdapter;
import com.ruukaze.gamewiz.apiService.GameDataCallback;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.models.Game;

import java.util.ArrayList;

public class ScreenshotFragment extends Fragment {
    private static int game_id;
    private TextView no_screenshots;

    public ScreenshotFragment(int game_id) {
        this.game_id = game_id;
    }

    public static ScreenshotFragment newInstance() {
        return new ScreenshotFragment(game_id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screenshot, container, false);

        RecyclerView screenshots = view.findViewById(R.id.screenshots);
        no_screenshots = view.findViewById(R.id.no_screenshots);
        DataSource.getGamesScreenshot(game_id, new GameDataCallback() {
            @Override
            public void onSuccess(ArrayList<Game> games) {
                try {
                    Game game = games.get(0);
                    screenshots.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    screenshots.setAdapter(new ScreenshotAdapter(game.getScreenshots()));
                } catch (Exception e) {
                    no_screenshots.setVisibility(View.VISIBLE);
                    screenshots.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        return view;
    }
}