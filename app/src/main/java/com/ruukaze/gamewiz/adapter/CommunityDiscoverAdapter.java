package com.ruukaze.gamewiz.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.MainActivity;
import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.databaseUtils.DatabaseHelper;
import com.ruukaze.gamewiz.models.Community;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;

public class CommunityDiscoverAdapter extends RecyclerView.Adapter<CommunityDiscoverAdapter.ViewHolder> {
    private ArrayList<Community> communities;
    private Context context;
    private User user;

    public CommunityDiscoverAdapter(User user, ArrayList<Community> communities, Context context) {
        this.user = user;
        this.communities = communities;
        this.context = context;
    }

    @NonNull
    @Override
    public CommunityDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_community_group, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityDiscoverAdapter.ViewHolder holder, int position) {
        Community community = communities.get(position);

        holder.community_banner.setImageResource(community.getIcon());
        holder.community_name.setText(community.getName());

        DatabaseHelper db = new DatabaseHelper(context);
        Cursor cursor = db.getReadableDatabase().rawQuery("SELECT COUNT(*) FROM users WHERE community_id = " + community.getId(), null);
        cursor.moveToFirst();
        holder.community_size.setText(cursor.getString(0) + " members");
        cursor.close();

        cursor = db.getReadableDatabase().rawQuery("SELECT COUNT(*) FROM posts WHERE community_id = " + community.getId(), null);
        cursor.moveToFirst();
        holder.community_posts.setText(cursor.getString(0) + " posts");
        cursor.close();

        holder.itemView.setOnClickListener(v -> {
            View popupView = LayoutInflater.from(v.getContext()).inflate(R.layout.scene_community, null);

            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );

            ImageView community_banner = popupView.findViewById(R.id.community_banner);
            community_banner.setImageResource(community.getIcon());

            TextView community_name = popupView.findViewById(R.id.community_name);
            community_name.setText(community.getName());

            TextView community_desc = popupView.findViewById(R.id.community_desc);
            community_desc.setText(community.getDescription());

            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

            Button join_community = popupView.findViewById(R.id.join_community);
            if (user != null) {
                join_community.setOnClickListener(v1 -> {
                    DatabaseHelper dbHelper = new DatabaseHelper(context);
                    dbHelper.joinCommunity(user.getId(), community.getId());
                    popupWindow.dismiss();
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                });
            } else {
                join_community.setVisibility(View.GONE);
            }

            ImageView close_scene = popupView.findViewById(R.id.close_scene);
            close_scene.setOnClickListener(v1 -> popupWindow.dismiss());
        });
    }

    @Override
    public int getItemCount() {
        return communities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView community_banner;
        private TextView community_name;
        private TextView community_size;
        private TextView community_posts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            community_banner = itemView.findViewById(R.id.community_banner);
            community_name = itemView.findViewById(R.id.community_name);
            community_size = itemView.findViewById(R.id.community_size);
            community_posts = itemView.findViewById(R.id.community_posts);
        }
    }
}