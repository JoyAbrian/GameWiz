package com.ruukaze.gamewiz.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ruukaze.gamewiz.MainActivity;
import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.adapter.CommunityPostAdapter;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Post;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CommunityFragment extends Fragment {
    private RecyclerView rv_posts;
    private NestedScrollView nested_scroll_view;
    private Button leave_community_button;
    private ImageView community_banner;
    private ImageView loading_screen;
    private TextView no_community_text;
    private TextView community_name;
    private TextView community_description;
    private TextView community_size;
    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.myLooper());

    private DatabaseHelper dbHelper;
    private static User user;

    public CommunityFragment(User user) {
        this.user = user;
    }

    public static CommunityFragment newInstance() {
        return new CommunityFragment(user);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new DatabaseHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        nested_scroll_view = view.findViewById(R.id.nested_scroll_view);
        community_banner = view.findViewById(R.id.community_banner);
        community_name = view.findViewById(R.id.community_name);
        community_description = view.findViewById(R.id.community_description);
        community_size = view.findViewById(R.id.community_size);
        loading_screen = view.findViewById(R.id.loading_screen);
        rv_posts = view.findViewById(R.id.rv_posts);
        no_community_text = view.findViewById(R.id.no_community_text);
        leave_community_button = view.findViewById(R.id.leave_community_button);

        loading_screen.setVisibility(View.VISIBLE);
        nested_scroll_view.setVisibility(View.GONE);
        if (user.getCommunity_id() == 0) {
            loading_screen.setVisibility(View.GONE);
            leave_community_button.setVisibility(View.GONE);
            no_community_text.setVisibility(View.VISIBLE);
        } else {
            executor.execute(() -> {
                try {
                    if (user.getCommunity_id() != 0) {
                        Cursor cursor1 = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM communities WHERE id = ?", new String[]{String.valueOf(user.getCommunity_id())});
                        if (cursor1.moveToFirst()) {
                            community_banner.setImageResource(cursor1.getInt(cursor1.getColumnIndexOrThrow("icon")));
                            community_name.setText(cursor1.getString(cursor1.getColumnIndexOrThrow("name")));
                            community_description.setText(cursor1.getString(cursor1.getColumnIndexOrThrow("description")));
                        }
                        cursor1.close();

                        Cursor cursor2 = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM users WHERE community_id = ?", new String[]{String.valueOf(user.getCommunity_id())});
                        if (cursor2.moveToFirst()) {
                            community_size.setText(cursor2.getCount() + " Members");
                        }
                        cursor2.close();

                        ArrayList<Post> posts = new ArrayList<>();
                        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM posts WHERE community_id = ? ORDER BY id DESC", new String[]{String.valueOf(user.getCommunity_id())});

                        if (cursor.moveToFirst()) {
                            do {
                                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                                int community_id = cursor.getInt(cursor.getColumnIndexOrThrow("community_id"));
                                int user_id = cursor.getInt(cursor.getColumnIndexOrThrow("user_id"));
                                String post = cursor.getString(cursor.getColumnIndexOrThrow("post"));
                                String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));

                                posts.add(new Post(id, community_id, user_id, post, image));
                            } while (cursor.moveToNext());
                        }
                        cursor.close();

                        rv_posts.setLayoutManager(new LinearLayoutManager(getContext()));
                        rv_posts.setAdapter(new CommunityPostAdapter(posts, getContext()));
                    }
                    Thread.sleep(2000);
                    handler.post(() -> {
                        loading_screen.setVisibility(View.GONE);
                        nested_scroll_view.setVisibility(View.VISIBLE);
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            leave_community_button.setOnClickListener(v -> {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("user", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("community_id", 0);
                editor.apply();

                dbHelper.leaveCommunity(user.getId());
                user.setCommunity_id(0);
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                getActivity().finish();
            });
        }

        return view;
    }
}