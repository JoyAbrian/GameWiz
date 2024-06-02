package com.ruukaze.gamewiz.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import pl.droidsonroids.gif.GifImageView;

public class ScreenshotFragment extends Fragment {
    private static int game_id;
    private GifImageView loading_screen;
    private RecyclerView screenshots;
    private TextView no_screenshots;
    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.myLooper());

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

        loading_screen = view.findViewById(R.id.loading_screen);
        screenshots = view.findViewById(R.id.screenshots);
        no_screenshots = view.findViewById(R.id.no_screenshots);

        loading_screen.setVisibility(View.VISIBLE);
        screenshots.setVisibility(View.GONE);
        no_screenshots.setVisibility(View.GONE);
        executor.execute(() -> {
            DataSource.getGamesScreenshot(game_id, new GameDataCallback() {
                @Override
                public void onSuccess(ArrayList<Game> games) {
                    if (!games.isEmpty()) {
                        Game game = games.get(0);
                        if (game.getScreenshots() != null) {
                            screenshots.setLayoutManager(new GridLayoutManager(getContext(), 2));
                            screenshots.setAdapter(new ScreenshotAdapter(game.getScreenshots()));
                        }
                    }
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            handler.post(() -> {
                loading_screen.setVisibility(View.GONE);
                if (screenshots.getAdapter() == null)
                    no_screenshots.setVisibility(View.VISIBLE);
                else if (screenshots.getAdapter().getItemCount() == 0)
                    no_screenshots.setVisibility(View.VISIBLE);
                else if (screenshots.getAdapter().getItemCount() > 0) {
                    screenshots.setVisibility(View.VISIBLE);
                }
            });
        });

        return view;
    }
}