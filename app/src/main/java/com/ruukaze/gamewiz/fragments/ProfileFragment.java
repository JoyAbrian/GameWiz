package com.ruukaze.gamewiz.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ruukaze.gamewiz.MainActivity;
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
    private Button logout_button;

    private DatabaseHelper dbHelper;
    private User user;
    private SharedPreferences sharedPreferences;

    public ProfileFragment(User user) {
        this.user = user;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        logout_button = view.findViewById(R.id.logout_button);

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

        logout_button.setOnClickListener(v -> {
            sharedPreferences = getContext().getSharedPreferences("user", getContext().MODE_PRIVATE);
            sharedPreferences.edit().clear().apply();
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });

        return view;
    }
}