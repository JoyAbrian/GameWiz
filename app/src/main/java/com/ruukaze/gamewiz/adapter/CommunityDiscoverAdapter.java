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
import com.ruukaze.gamewiz.models.Community;

import java.util.ArrayList;

public class CommunityDiscoverAdapter extends RecyclerView.Adapter<CommunityDiscoverAdapter.ViewHolder>{
    private ArrayList<Community> communities;
    private Context context;

    public CommunityDiscoverAdapter(ArrayList<Community> communities, Context context) {
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

        cursor = db.getReadableDatabase().rawQuery("SELECT COUNT(*) FROM posts WHERE community_id = " + community.getId(), null);
        cursor.moveToFirst();
        holder.community_posts.setText(cursor.getString(0) + " posts");

        cursor.close();
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
