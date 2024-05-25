package com.ruukaze.gamewiz;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import com.ruukaze.gamewiz.Fragment.CommunityFragment;
import com.ruukaze.gamewiz.Fragment.DiscoverFragment;
import com.ruukaze.gamewiz.Fragment.GamesFragment;
import com.ruukaze.gamewiz.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private ImageView home_img, community_img, games_img, profile_img; // FOOTER IMAGES

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_img = findViewById(R.id.home_img);
        community_img = findViewById(R.id.community_img);
        games_img = findViewById(R.id.games_img);
        profile_img = findViewById(R.id.profile_img);

        home_img.setOnClickListener(v -> inflateHomeFragment());
        community_img.setOnClickListener(v -> inflateCommunityFragment());
        games_img.setOnClickListener(v -> inflateGamesFragment());
        profile_img.setOnClickListener(v -> inflateProfileFragment());

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