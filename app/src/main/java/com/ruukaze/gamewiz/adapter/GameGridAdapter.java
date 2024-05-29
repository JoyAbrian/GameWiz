package com.ruukaze.gamewiz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.models.Company;
import com.ruukaze.gamewiz.models.Game;
import com.ruukaze.gamewiz.models.ReleaseDate;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameGridAdapter extends RecyclerView.Adapter<GameGridAdapter.ViewHolder>{
    private final ArrayList<Game> games;

    public GameGridAdapter(ArrayList<Game> games) {
        this.games = games;
    }

    @NonNull
    @Override
    public GameGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_game_library, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GameGridAdapter.ViewHolder holder, int position) {
        Game game = games.get(position);

        ReleaseDate releaseDate = game.getRelease_dates().get(0);

        Picasso.get().load("https://images.igdb.com/igdb/image/upload/t_cover_big/" + game.getCover().getImage_id() + ".jpg").into(holder.game_cover);
        holder.game_title.setText(game.getName());
        holder.game_release_date.setText(releaseDate.getHuman());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView game_cover;
        private final TextView game_title;
        private final TextView game_release_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            game_cover = itemView.findViewById(R.id.game_cover);
            game_title = itemView.findViewById(R.id.game_title);
            game_release_date = itemView.findViewById(R.id.game_release_date);
        }
    }
}