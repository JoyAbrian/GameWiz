package com.ruukaze.gamewiz.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.models.Game;

public class ScreenshotFragment extends Fragment {
    private static int game_id;
    private RecyclerView screenshots;
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

        screenshots = view.findViewById(R.id.screenshots);
        DataSource.getGamesScreenshot(game_id, screenshots);

        return view;
    }
}