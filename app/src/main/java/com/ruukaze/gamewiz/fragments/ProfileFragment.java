package com.ruukaze.gamewiz.fragments;

import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.User;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private CircleImageView profile_image;
    private TextView profile_username;
    private TextView profile_date_register;
    private TextView profile_username_2;
    private TextView profile_full_name;
    private TextView profile_email;

    private int user_id;
    private DatabaseHelper dbHelper;
    private User user;

    public ProfileFragment(int user_id) {
        this.user_id = user_id;
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
        System.out.println(user_id);
        cursor.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profile_image = view.findViewById(R.id.profile_image);
        profile_username = view.findViewById(R.id.profile_username);
        profile_date_register = view.findViewById(R.id.profile_date_register);
        profile_username_2 = view.findViewById(R.id.profile_username_2);
        profile_full_name = view.findViewById(R.id.profile_full_name);
        profile_email = view.findViewById(R.id.profile_email);

        if (user != null) {
            profile_image.setImageResource(user.getAvatar());
            profile_username.setText(user.getUsername());
            profile_date_register.setText(user.getDateOfRegister());
            profile_username_2.setText(user.getUsername());
            profile_full_name.setText(user.getFullname());
            profile_email.setText(user.getEmail());
        } else {
            profile_username.setText("User not found");
        }

        return view;
    }
}