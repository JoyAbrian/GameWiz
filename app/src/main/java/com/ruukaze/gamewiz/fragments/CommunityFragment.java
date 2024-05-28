package com.ruukaze.gamewiz.fragments;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.adapter.CommunityPostAdapter;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Post;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;

public class CommunityFragment extends Fragment {
    private RecyclerView rv_posts;

    private static int user_id;
    private DatabaseHelper dbHelper;
    private User user;
    private SharedPreferences sharedPreferences;

    public CommunityFragment(int user_id) {
        this.user_id = user_id;
    }

    public static CommunityFragment newInstance() {
        return new CommunityFragment(user_id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHelper = new DatabaseHelper(getContext());
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM users WHERE id = ?", new String[]{String.valueOf(user_id)});

        user = null;
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
            String dateOfRegister = cursor.getString(cursor.getColumnIndexOrThrow("dateOfRegister"));
            int avatar = cursor.getInt(cursor.getColumnIndexOrThrow("avatar"));
            int community_id = cursor.getInt(cursor.getColumnIndexOrThrow("community_id"));
            String fullname = cursor.getString(cursor.getColumnIndexOrThrow("fullname"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));

            user = new User(id, username, dateOfRegister, avatar, community_id, fullname, email, password);
        }
        cursor.close();

        sharedPreferences = getContext().getSharedPreferences("user", getContext().MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        if (user.getCommunity_id() != 0) {
            ArrayList<Post> posts = new ArrayList<>();
            Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM posts WHERE community_id = ? ORDER BY id DESC", new String[]{String.valueOf(user.getCommunity_id())});

            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                    int community_id = cursor.getInt(cursor.getColumnIndexOrThrow("community_id"));
                    int user_id = cursor.getInt(cursor.getColumnIndexOrThrow("user_id"));
                    String post = cursor.getString(cursor.getColumnIndexOrThrow("post"));
                    int image = cursor.getInt(cursor.getColumnIndexOrThrow("image"));

                    posts.add(new Post(id, community_id, user_id, post, image));
                } while (cursor.moveToNext());
            }
            cursor.close();

            rv_posts = view.findViewById(R.id.rv_posts);
            rv_posts.setLayoutManager(new LinearLayoutManager(getContext()));
            rv_posts.setAdapter(new CommunityPostAdapter(posts, getContext()));
        } else {

        }

        return view;
    }
}