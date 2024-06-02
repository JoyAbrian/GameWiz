package com.ruukaze.gamewiz.adapter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

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

        String url = "https://images.igdb.com/igdb/image/upload/t_screenshot_huge/" + screenshot.getImage_id() + ".jpg";
        Picasso.get().load(url).into(holder.img_screenshot);

        holder.itemView.setOnClickListener(v -> {
            View popupView = LayoutInflater.from(v.getContext()).inflate(R.layout.scene_screenshot, null);

            PopupWindow popupWindow = new PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );

            ImageView img_screenshot = popupView.findViewById(R.id.screenshot_image);
            Picasso.get().load(url).into(img_screenshot);

            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

            ImageView close_scene = popupView.findViewById(R.id.close_scene);
            close_scene.setOnClickListener(v1 -> popupWindow.dismiss());
        });
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
