package com.ruukaze.gamewiz;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.ruukaze.gamewiz.adapter.FragmentAdapter;
import com.ruukaze.gamewiz.apiService.GameDataCallback;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.fragments.ScreenshotFragment;
import com.ruukaze.gamewiz.fragments.SummaryFragment;
import com.ruukaze.gamewiz.models.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import pl.droidsonroids.gif.GifImageView;

public class DetailActivity extends AppCompatActivity {
    private GifImageView loading_screen;
    private FrameLayout detail_screen;
    private ViewPager2 view_pager;
    private ImageView toggle_back;
    private ImageView cover_banner;
    private ImageView cover_image;
    private TextView game_title;
    private TextView game_release;
    private int game_id;

    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        view_pager = findViewById(R.id.view_pager);
        toggle_back = findViewById(R.id.toggle_back);
        cover_banner = findViewById(R.id.cover_banner);
        cover_image = findViewById(R.id.cover_image);
        game_title = findViewById(R.id.game_title);
        game_release = findViewById(R.id.game_release);
        loading_screen = findViewById(R.id.loading_screen);
        detail_screen = findViewById(R.id.detail_screen);

        toggle_back.setOnClickListener(v -> finish());

        loading_screen.setVisibility(View.VISIBLE);
        detail_screen.setVisibility(View.GONE);
        view_pager.setVisibility(View.GONE);
        executor.execute(() -> {
            game_id = getIntent().getIntExtra("game_id", 0);
            DataSource.getGamesDetails(game_id, new GameDataCallback() {
                @Override
                public void onSuccess(ArrayList<Game> games) {
                    Game game = games.get(0);
                    if (game.getCover() != null) {
                        String banner_url = "https://images.igdb.com/igdb/image/upload/t_screenshot_huge/" + game.getScreenshots().get(0).getImage_id() + ".jpg";
                        Picasso.get().load(banner_url).into(cover_banner);
                    }
                    if (game.getScreenshots() != null) {
                        String cover_url = "https://images.igdb.com/igdb/image/upload/t_cover_big/" + game.getCover().getImage_id() + ".jpg";
                        Picasso.get().load(cover_url).into(cover_image);
                    }

                    game_title.setText(game.getName());
                    if (game.getRelease_dates() != null) {
                        game_release.setText(game.getRelease_dates().get(0).getHuman());
                    }
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(() -> {
                loading_screen.setVisibility(View.GONE);
                detail_screen.setVisibility(View.VISIBLE);
                view_pager.setVisibility(View.VISIBLE);
            });
        });

        FragmentAdapter adapter = new FragmentAdapter(this);
        adapter.addFragment(new SummaryFragment(game_id));
        adapter.addFragment(new ScreenshotFragment(game_id));

        view_pager.setAdapter(adapter);
    }
}