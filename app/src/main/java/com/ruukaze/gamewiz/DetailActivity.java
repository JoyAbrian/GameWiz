package com.ruukaze.gamewiz;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.ruukaze.gamewiz.adapter.FragmentAdapter;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.fragments.ScreenshotFragment;
import com.ruukaze.gamewiz.fragments.SummaryFragment;
import com.ruukaze.gamewiz.models.Game;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private ViewPager2 view_pager;
    private ImageView toggle_back;
    private ImageView cover_banner;
    private ImageView cover_image;
    private TextView game_title;
    private TextView game_release;
    private int game_id;

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

        toggle_back.setOnClickListener(v -> finish());

        game_id = getIntent().getIntExtra("game_id", 0);
        DataSource.getGamesDetails(game_id, cover_banner, cover_image, game_title, game_release);

        FragmentAdapter adapter = new FragmentAdapter(this);
        adapter.addFragment(new SummaryFragment(game_id));
        adapter.addFragment(new ScreenshotFragment(game_id));

        view_pager.setAdapter(adapter);
    }
}