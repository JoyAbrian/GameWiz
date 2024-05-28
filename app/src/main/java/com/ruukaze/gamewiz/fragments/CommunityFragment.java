package com.ruukaze.gamewiz.fragments;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.adapter.CommunityPostAdapter;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Post;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;

public class CommunityFragment extends Fragment {
    private RecyclerView rv_posts;
    private ImageView community_banner;
    private TextView community_name;
    private TextView community_description;
    private TextView community_size;

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
        sharedPreferences = getContext().getSharedPreferences("user", getContext().MODE_PRIVATE);

        new LoadUserDataTask().execute(user_id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        community_banner = view.findViewById(R.id.community_banner);
        community_name = view.findViewById(R.id.community_name);
        community_description = view.findViewById(R.id.community_description);
        community_size = view.findViewById(R.id.community_size);
        rv_posts = view.findViewById(R.id.rv_posts);

        return view;
    }

    private class LoadUserDataTask extends AsyncTask<Integer, Void, Void> {
        @Override
        protected Void doInBackground(Integer... params) {
            int userId = params[0];

            Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM users WHERE id = ?", new String[]{String.valueOf(userId)});
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

            if (user != null && user.getCommunity_id() != 0) {
                Cursor communityCursor = dbHelper.getReadableDatabase().rawQuery(
                        "SELECT c.icon, c.name, c.description, COUNT(u.id) AS size " +
                                "FROM communities c LEFT JOIN users u ON c.id = u.community_id " +
                                "WHERE c.id = ?", new String[]{String.valueOf(user.getCommunity_id())});

                if (communityCursor.moveToFirst()) {
                    int icon = communityCursor.getInt(communityCursor.getColumnIndexOrThrow("icon"));
                    String name = communityCursor.getString(communityCursor.getColumnIndexOrThrow("name"));
                    String description = communityCursor.getString(communityCursor.getColumnIndexOrThrow("description"));
                    int size = communityCursor.getInt(communityCursor.getColumnIndexOrThrow("size"));

                    getActivity().runOnUiThread(() -> {
                        community_banner.setImageResource(icon);
                        community_name.setText(name);
                        community_description.setText(description);
                        community_size.setText(size + " Members");
                    });
                }
                communityCursor.close();

                ArrayList<Post> posts = new ArrayList<>();
                Cursor postCursor = dbHelper.getReadableDatabase().rawQuery(
                        "SELECT * FROM posts WHERE community_id = ? ORDER BY id DESC", new String[]{String.valueOf(user.getCommunity_id())});

                if (postCursor.moveToFirst()) {
                    do {
                        int id = postCursor.getInt(postCursor.getColumnIndexOrThrow("id"));
                        int community_id = postCursor.getInt(postCursor.getColumnIndexOrThrow("community_id"));
                        int user_id = postCursor.getInt(postCursor.getColumnIndexOrThrow("user_id"));
                        String post = postCursor.getString(postCursor.getColumnIndexOrThrow("post"));
                        int image = postCursor.getInt(postCursor.getColumnIndexOrThrow("image"));

                        posts.add(new Post(id, community_id, user_id, post, image));
                    } while (postCursor.moveToNext());
                }
                postCursor.close();

                getActivity().runOnUiThread(() -> {
                    rv_posts.setLayoutManager(new LinearLayoutManager(getContext()));
                    rv_posts.setAdapter(new CommunityPostAdapter(posts, getContext()));
                });
            }
            return null;
        }
    }
}