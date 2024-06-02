package com.ruukaze.gamewiz.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> users;

    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_community_person, parent, false);
        return new UserAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);

        holder.user_name.setText(user.getUsername());
        holder.user_profile.setImageResource(user.getAvatar());

        holder.itemView.setOnClickListener(v -> {
            View popupView = LayoutInflater.from(v.getContext()).inflate(R.layout.scene_users, null);

            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );

            ImageView user_avatar = popupView.findViewById(R.id.user_avatar);
            user_avatar.setImageResource(user.getAvatar());

            TextView user_name = popupView.findViewById(R.id.user_name);
            user_name.setText(user.getUsername());

            TextView user_fullname = popupView.findViewById(R.id.user_full_name);
            user_fullname.setText(user.getFullname());

            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

            ImageView close_scene = popupView.findViewById(R.id.close_scene);
            close_scene.setOnClickListener(v1 -> popupWindow.dismiss());
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView user_profile;
        private TextView user_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_profile = itemView.findViewById(R.id.user_profile);
            user_name = itemView.findViewById(R.id.user_name);
        }
    }
}
