package com.ruukaze.gamewiz;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ruukaze.gamewiz.adapter.FragmentAdapter;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.fragments.AccessDeniedFragment;
import com.ruukaze.gamewiz.fragments.CommunityFragment;
import com.ruukaze.gamewiz.fragments.DiscoverFragment;
import com.ruukaze.gamewiz.fragments.GamesFragment;
import com.ruukaze.gamewiz.fragments.ProfileFragment;
import com.ruukaze.gamewiz.models.User;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottom_navigation;
    private ViewPager2 parent_fragment;

    private DatabaseHelper dbHelper;
    private SharedPreferences sharedPreferences;

    private boolean isAuth;
    private int user_id;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_navigation = findViewById(R.id.bottom_navigation);
        parent_fragment = findViewById(R.id.parent_fragment);

        dbHelper = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);

        isAuth = sharedPreferences.getBoolean("isAuth", false);
        user_id = sharedPreferences.getInt("user_id", 0);

        if (isAuth) {
            user = loadUser();
        }

        FragmentAdapter fragmentAdapter = new FragmentAdapter(this);
        if (isAuth) {
            fragmentAdapter.addFragment(new DiscoverFragment(user));
        } else {
            fragmentAdapter.addFragment(new DiscoverFragment(null));
        }
        if (isAuth) {
            fragmentAdapter.addFragment(new CommunityFragment(user));
            fragmentAdapter.addFragment(new GamesFragment(user));
            fragmentAdapter.addFragment(new ProfileFragment(user));
        } else {
            fragmentAdapter.addFragment(new AccessDeniedFragment());
            fragmentAdapter.addFragment(new AccessDeniedFragment());
            fragmentAdapter.addFragment(new AccessDeniedFragment());
        }
        parent_fragment.setAdapter(fragmentAdapter);
        parent_fragment.setUserInputEnabled(false);

        bottom_navigation.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.action_discover) {
                parent_fragment.setCurrentItem(0);
                return true;
            } else if (itemId == R.id.action_community) {
                parent_fragment.setCurrentItem(1);
                return true;
            } else if (itemId == R.id.action_games) {
                parent_fragment.setCurrentItem(2);
                return true;
            } else if (itemId == R.id.action_profile) {
                parent_fragment.setCurrentItem(3);
                return true;
            } else {
                return false;
            }
        });

        // Link ViewPager2 swipe to BottomNavigationView with if-else
        parent_fragment.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0) {
                    bottom_navigation.setSelectedItemId(R.id.action_discover);
                } else if (position == 1) {
                    bottom_navigation.setSelectedItemId(R.id.action_community);
                } else if (position == 2) {
                    bottom_navigation.setSelectedItemId(R.id.action_games);
                } else if (position == 3) {
                    bottom_navigation.setSelectedItemId(R.id.action_profile);
                }
            }
        });
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