package com.ruukaze.gamewiz;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.ruukaze.gamewiz.adapter.FragmentAdapter;
import com.ruukaze.gamewiz.fragments.ScreenshotFragment;
import com.ruukaze.gamewiz.fragments.SummaryFragment;

public class DetailActivity extends AppCompatActivity {
    private ViewPager2 view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        view_pager = findViewById(R.id.view_pager);

        FragmentAdapter adapter = new FragmentAdapter(this);
        adapter.addFragment(new SummaryFragment());
        adapter.addFragment(new ScreenshotFragment());

        view_pager.setAdapter(adapter);
    }
}