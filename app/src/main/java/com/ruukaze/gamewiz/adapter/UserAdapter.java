package com.ruukaze.gamewiz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
