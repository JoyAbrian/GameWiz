package com.ruukaze.gamewiz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.models.Cover;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ScreenshotAdapter extends RecyclerView.Adapter<ScreenshotAdapter.ViewHolder>{
    private ArrayList<Cover> screenshots;

    public ScreenshotAdapter(ArrayList<Cover> screenshots) {
        this.screenshots = screenshots;
    }

    @NonNull
    @Override
    public ScreenshotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_screenshot, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ScreenshotAdapter.ViewHolder holder, int position) {
        Cover screenshot = screenshots.get(position);

        String url = "https://images.igdb.com/igdb/image/upload/t_cover_big/" + screenshot.getImage_id() + ".jpg";
        Picasso.get().load(url).into(holder.img_screenshot);
    }

    @Override
    public int getItemCount() {
        return screenshots.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_screenshot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_screenshot = itemView.findViewById(R.id.img_screenshot);
        }
    }
}
