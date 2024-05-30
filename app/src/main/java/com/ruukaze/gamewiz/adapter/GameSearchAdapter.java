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
import com.ruukaze.gamewiz.models.InvolvedCompany;
import com.ruukaze.gamewiz.models.Platform;
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

            if (game.getRelease_dates() != null && game.getInvolved_companies() != null) {
                String releaseDate = game.getRelease_dates().get(0).getHuman();
                for (InvolvedCompany involvedCompany: game.getInvolved_companies()) {
                    if (involvedCompany.isDeveloper()) {
                        if (involvedCompany.getCompany() != null) {
                            String developer = involvedCompany.getCompany().getName();
                            holder.game_detail.setText(releaseDate + " | " + developer);
                            break;
                        }
                    }
                }
            } else {
                holder.game_detail.setText("Not Found");
            }

            if (game.getPlatforms() != null) {
                StringBuilder platformBuilder = new StringBuilder();
                for (Platform platform: game.getPlatforms()) {
                    platformBuilder.append(platform.getName()).append(", ");
                }
                String platformString = platformBuilder.toString();
                holder.game_platform.setText(platformString.substring(0, platformString.length() - 2));
            } else {
                holder.game_platform.setText("Not Found");
            }

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
            game_detail = itemView.findViewById(R.id.game_detail);
            game_platform = itemView.findViewById(R.id.game_platform);
            toggle_add = itemView.findViewById(R.id.toggle_add);
        }
    }
}
