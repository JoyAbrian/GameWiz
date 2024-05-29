package com.ruukaze.gamewiz.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommunityPostAdapter extends RecyclerView.Adapter<CommunityPostAdapter.ViewHolder>{
    private ArrayList<Post> posts;
    private Context context;

    public CommunityPostAdapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public CommunityPostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_community_post, parent, false);
        return new CommunityPostAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityPostAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);

        DatabaseHelper dbHelper = new DatabaseHelper(context);
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery("SELECT * FROM users WHERE id = ?", new String[]{String.valueOf(post.getUser_id())});
        if (cursor.moveToFirst()) {
            holder.user_profile.setImageResource(cursor.getInt(cursor.getColumnIndexOrThrow("avatar")));
            holder.user_name.setText(cursor.getString(cursor.getColumnIndexOrThrow("username")));
            holder.community_post.setText(post.getPost());
            Picasso.get().load(post.getImage()).into(holder.postImageView);
        }
        cursor.close();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView user_profile;
        private TextView user_name;
        private TextView community_post;
        private ImageView postImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user_profile = itemView.findViewById(R.id.user_profile);
            user_name = itemView.findViewById(R.id.user_name);
            community_post = itemView.findViewById(R.id.community_post);
            postImageView = itemView.findViewById(R.id.postImageView);
        }
    }
}
