package com.ruukaze.gamewiz;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import com.ruukaze.gamewiz.Fragment.CommunityFragment;
import com.ruukaze.gamewiz.Fragment.DiscoverFragment;
import com.ruukaze.gamewiz.Fragment.GamesFragment;
import com.ruukaze.gamewiz.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private ImageView home_img, community_img, games_img, profile_img; // FOOTER IMAGES
    private LinearLayout toggle_home, toggle_community, toggle_games, toggle_profile; // FOOTER TOGGLE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_img = findViewById(R.id.home_img);
        community_img = findViewById(R.id.community_img);
        games_img = findViewById(R.id.games_img);
        profile_img = findViewById(R.id.profile_img);

        toggle_home = findViewById(R.id.toggle_home);
        toggle_community = findViewById(R.id.toggle_community);
        toggle_games = findViewById(R.id.toggle_games);
        toggle_profile = findViewById(R.id.toggle_profile);

        toggle_home.setOnClickListener(v -> inflateHomeFragment());
        toggle_community.setOnClickListener(v -> inflateCommunityFragment());
        toggle_games.setOnClickListener(v -> inflateGamesFragment());
        toggle_profile.setOnClickListener(v -> inflateProfileFragment());

        inflateHomeFragment();
    }

    private void inactiveFooter() {
        home_img.setImageResource(R.drawable.vector_home);
        community_img.setImageResource(R.drawable.vector_community);
        games_img.setImageResource(R.drawable.vector_games);
        profile_img.setImageResource(R.drawable.vector_profile);
    }

    private void inflateHomeFragment() {
        inactiveFooter();
        home_img.setImageResource(R.drawable.vector_home_active);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.parent_fragment, new DiscoverFragment())
                .commit();
    }

    private void inflateCommunityFragment() {
        inactiveFooter();
        community_img.setImageResource(R.drawable.vector_community_active);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.parent_fragment, new CommunityFragment())
                .commit();
    }

    private void inflateGamesFragment() {
        inactiveFooter();
        games_img.setImageResource(R.drawable.vector_games_active);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.parent_fragment, new GamesFragment())
                .commit();
    }

    private void inflateProfileFragment() {
        inactiveFooter();
        profile_img.setImageResource(R.drawable.vector_profile_active);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.parent_fragment, new ProfileFragment())
                .commit();
    }
}