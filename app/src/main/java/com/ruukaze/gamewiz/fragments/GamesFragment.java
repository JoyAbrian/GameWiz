package com.ruukaze.gamewiz.fragments;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Library;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;

public class GamesFragment extends Fragment {
    private TextView library_count;
    private TextView wishlist_count;
    private TextView playing_count;
    private TextView pause_count;
    private TextView completed_count;

    private static User user;
    private DatabaseHelper dbHelper;

    public GamesFragment(User user) {
        this.user = user;
    }

    public static GamesFragment newInstance() {
        return new GamesFragment(user);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DatabaseHelper(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games, container, false);

        library_count = view.findViewById(R.id.library_count);
        wishlist_count = view.findViewById(R.id.wishlist_count);
        playing_count = view.findViewById(R.id.playing_count);
        pause_count = view.findViewById(R.id.pause_count);
        completed_count = view.findViewById(R.id.completed_count);

        if (user != null) {
            Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM library WHERE user_id = ?", new String[]{String.valueOf(user.getId())});
            ArrayList<Library> libraries = new ArrayList<>();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                int user_id = cursor.getInt(cursor.getColumnIndexOrThrow("user_id"));
                int game_id = cursor.getInt(cursor.getColumnIndexOrThrow("game_id"));
                String status = cursor.getString(cursor.getColumnIndexOrThrow("type"));

                libraries.add(new Library(id, user_id, game_id, status));
            }
            cursor.close();

            int library_count_int = 0;
            int wishlist_count_int = 0;
            int playing_count_int = 0;
            int pause_count_int = 0;
            int completed_count_int = 0;

            for (Library library : libraries) {
                if (library.getType().equals("library")) {
                    library_count_int++;
                } else if (library.getType().equals("wishlist")) {
                    wishlist_count_int++;
                } else if (library.getType().equals("playing")) {
                    library_count_int++;
                    playing_count_int++;
                } else if (library.getType().equals("pause")) {
                    library_count_int++;
                    pause_count_int++;
                } else if (library.getType().equals("completed")) {
                    library_count_int++;
                    completed_count_int++;
                }
            }

            library_count.setText(String.valueOf(library_count_int));
            wishlist_count.setText(String.valueOf(wishlist_count_int));
            playing_count.setText(String.valueOf(playing_count_int));
            pause_count.setText(String.valueOf(pause_count_int));
            completed_count.setText(String.valueOf(completed_count_int));

        } else {
            library_count.setText("user not found 404");
            wishlist_count.setText("user not found 404");
            playing_count.setText("user not found 404");
            pause_count.setText("user not found 404");
            completed_count.setText("user not found 404");
        }

        return view;
    }
}