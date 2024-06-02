package com.ruukaze.gamewiz.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ruukaze.gamewiz.MainActivity;
import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.adapter.AvatarAdapter;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.User;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private CircleImageView profile_image;
    private ImageView toggle_edit;
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
        toggle_edit = view.findViewById(R.id.toggle_edit);

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

        toggle_edit.setOnClickListener(v -> {
            View popupView = LayoutInflater.from(v.getContext()).inflate(R.layout.scene_edit_profile, null);

            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );

            ViewPager2 avatar_view_pager = popupView.findViewById(R.id.avatar_view_pager);
            int[] images = {R.drawable.avatar_1, R.drawable.avatar_2, R.drawable.avatar_3, R.drawable.avatar_4, R.drawable.avatar_5, R.drawable.avatar_6, R.drawable.avatar_7, R.drawable.avatar_8, R.drawable.avatar_9, R.drawable.avatar_10, R.drawable.avatar_11, R.drawable.avatar_12, R.drawable.avatar_13, R.drawable.avatar_14, R.drawable.avatar_15, R.drawable.avatar_16, R.drawable.avatar_17, R.drawable.avatar_18, R.drawable.avatar_19, R.drawable.avatar_20, R.drawable.avatar_21, R.drawable.avatar_22, R.drawable.avatar_23, R.drawable.avatar_24, R.drawable.avatar_25, R.drawable.avatar_26, R.drawable.avatar_27, R.drawable.avatar_28, R.drawable.avatar_29, R.drawable.avatar_30, R.drawable.avatar_31, R.drawable.avatar_32, R.drawable.avatar_33, R.drawable.avatar_34, R.drawable.avatar_35, R.drawable.avatar_36, R.drawable.avatar_37, R.drawable.avatar_38, R.drawable.avatar_39, R.drawable.avatar_40, R.drawable.avatar_41, R.drawable.avatar_42, R.drawable.avatar_43, R.drawable.avatar_44, R.drawable.avatar_45, R.drawable.avatar_46, R.drawable.avatar_47, R.drawable.avatar_48, R.drawable.avatar_49, R.drawable.avatar_50};
            avatar_view_pager.setAdapter(new AvatarAdapter(v.getContext(), images));

            EditText scene_profile_username = popupView.findViewById(R.id.profile_username);
            scene_profile_username.setText(user.getUsername());

            EditText scene_profile_full_name = popupView.findViewById(R.id.profile_full_name);
            scene_profile_full_name.setText(user.getFullname());

            EditText scene_profile_email = popupView.findViewById(R.id.profile_email);
            scene_profile_email.setText(user.getEmail());

            EditText scene_profile_password = popupView.findViewById(R.id.profile_password);
            scene_profile_password.setText(user.getPassword());

            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

            ImageView close_scene = popupView.findViewById(R.id.close_scene);
            close_scene.setOnClickListener(v1 -> popupWindow.dismiss());
        });

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