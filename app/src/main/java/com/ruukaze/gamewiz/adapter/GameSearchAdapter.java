package com.ruukaze.gamewiz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.models.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GameSearchAdapter extends RecyclerView.Adapter<GameSearchAdapter.ViewHolder> {
    private final ArrayList<Game> games;

    public GameSearchAdapter(ArrayList<Game> games) {
        this.games = games;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_game_search, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GameSearchAdapter.ViewHolder holder, int position) {
        Game game = games.get(position);

        if (game != null) {
            holder.game_title.setText(game.getName());
            if (game.getCover() != null) {
                Picasso.get().load("https://images.igdb.com/igdb/image/upload/t_cover_big/" + game.getCover().getImage_id() + ".jpg").into(holder.game_cover);
            }
        }
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView game_cover;
        private TextView game_title;
        private TextView game_detail;
        private TextView game_platform;
        private ImageView toggle_add;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            game_cover = itemView.findViewById(R.id.game_cover);
            game_title = itemView.findViewById(R.id.game_title);
            toggle_add = itemView.findViewById(R.id.toggle_add);
        }
    }
}
