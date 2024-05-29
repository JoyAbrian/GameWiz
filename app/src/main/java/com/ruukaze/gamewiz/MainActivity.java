package com.ruukaze.gamewiz;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.fragments.AccessDeniedFragment;
import com.ruukaze.gamewiz.fragments.CommunityFragment;
import com.ruukaze.gamewiz.fragments.DiscoverFragment;
import com.ruukaze.gamewiz.fragments.GamesFragment;
import com.ruukaze.gamewiz.fragments.ProfileFragment;
import com.ruukaze.gamewiz.models.User;

public class MainActivity extends AppCompatActivity {
    private ImageView home_img, community_img, games_img, profile_img; // FOOTER IMAGES
    private LinearLayout toggle_home, toggle_community, toggle_games, toggle_profile; // FOOTER TOGGLE

    private DatabaseHelper dbHelper;
    private SharedPreferences sharedPreferences;

    private boolean isAuth;
    private int user_id;
    private User user;

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

        isAuth = sharedPreferences.getBoolean("isAuth", false);
        user_id = sharedPreferences.getInt("user_id", 0);

        if (isAuth) {
            user = loadUser();
        }

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

    private void setFragmentWithAnimation(Fragment fragment, boolean isLeft) {
        int enterAnim = isLeft ? R.anim.slide_left_in : R.anim.slide_right_in;
        int exitAnim = isLeft ? R.anim.slide_left_out : R.anim.slide_right_out;

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(enterAnim, exitAnim)
                .replace(R.id.parent_fragment, fragment)
                .commit();
    }

    private void inflateHomeFragment() {
        inactiveFooter();
        home_img.setImageResource(R.drawable.vector_home_active);
        setFragmentWithAnimation(new DiscoverFragment(), true);
    }

    private void inflateCommunityFragment() {
        inactiveFooter();
        community_img.setImageResource(R.drawable.vector_community_active);
        if (isAuth) {
            setFragmentWithAnimation(new CommunityFragment(user), true);
        } else {
            inflateAccessDeniedFragment();
        }
    }

    private void inflateGamesFragment() {
        inactiveFooter();
        games_img.setImageResource(R.drawable.vector_games_active);
        if (isAuth) {
            setFragmentWithAnimation(new GamesFragment(user), false);
        } else {
            inflateAccessDeniedFragment();
        }
    }

    private void inflateProfileFragment() {
        inactiveFooter();
        profile_img.setImageResource(R.drawable.vector_profile_active);

        if (isAuth) {
            setFragmentWithAnimation(new ProfileFragment(user), false);
        } else {
            inflateAccessDeniedFragment();
        }
    }

    private void inflateAccessDeniedFragment() {
        setFragmentWithAnimation(new AccessDeniedFragment(), false);
    }

    public User loadUser() {
        dbHelper = new DatabaseHelper(this);
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM users WHERE id = ?", new String[]{String.valueOf(user_id)});

        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
            String dateOfRegister = cursor.getString(cursor.getColumnIndexOrThrow("dateOfRegister"));
            int avatar = cursor.getInt(cursor.getColumnIndexOrThrow("avatar"));
            int community_id = cursor.getInt(cursor.getColumnIndexOrThrow("community_id"));
            String fullname = cursor.getString(cursor.getColumnIndexOrThrow("fullname"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));

            return new User(id, username, dateOfRegister, avatar, community_id, fullname, email, password);
        }
        cursor.close();
        return null;
    }
}