package com.ruukaze.gamewiz;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.fragments.AccessDeniedFragment;
import com.ruukaze.gamewiz.fragments.CommunityFragment;
import com.ruukaze.gamewiz.fragments.DiscoverFragment;
import com.ruukaze.gamewiz.fragments.GamesFragment;
import com.ruukaze.gamewiz.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private ImageView home_img, community_img, games_img, profile_img; // FOOTER IMAGES
    private LinearLayout toggle_home, toggle_community, toggle_games, toggle_profile; // FOOTER TOGGLE

    private DatabaseHelper dbHelper;
    private SharedPreferences sharedPreferences;

    private boolean isAuth;

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

        dbHelper = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        isAuth = sharedPreferences.getBoolean("isAuth", false);

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
        if (isAuth) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.parent_fragment, new CommunityFragment())
                    .commit();
        } else {
            inflateAccessDeniedFragment();
        }
    }

    private void inflateAccessDeniedFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.parent_fragment, new AccessDeniedFragment())
                .commit();
    }

    private void inflateGamesFragment() {
        inactiveFooter();
        games_img.setImageResource(R.drawable.vector_games_active);
        if (isAuth) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.parent_fragment, new GamesFragment())
                    .commit();
        } else {
            inflateAccessDeniedFragment();
        }
    }

    private void inflateProfileFragment() {
        inactiveFooter();
        profile_img.setImageResource(R.drawable.vector_profile_active);
        if (isAuth) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.parent_fragment, new ProfileFragment())
                    .commit();
        } else {
            inflateAccessDeniedFragment();
        }
    }

    private void readDummyUser() {
        // Attempt to read from the database to trigger its creation
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USERS, null);
        if (cursor.moveToFirst()) {
            String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
            System.out.println("First user in the database: " + username);
        }
        cursor.close();
    }
}