package com.ruukaze.gamewiz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import com.ruukaze.gamewiz.Fragment.BottomNavigationFragment;
import com.ruukaze.gamewiz.Fragment.DiscoverFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentContainerView parent_fragment;
    private FragmentContainerView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent_fragment = findViewById(R.id.parent_fragment);
        bottom_nav = findViewById(R.id.bottom_nav);

        inflateHomeFragment();
        inflateBottomNavigation();
    }

    private void inflateBottomNavigation() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.bottom_nav, new BottomNavigationFragment())
                .commit();
    }

    private void inflateHomeFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.parent_fragment, new DiscoverFragment())
                .commit();
    }
}