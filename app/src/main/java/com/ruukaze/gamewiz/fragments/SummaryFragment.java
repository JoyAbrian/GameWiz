package com.ruukaze.gamewiz.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.databaseUtils.DataSource;
import com.ruukaze.gamewiz.models.Game;

public class SummaryFragment extends Fragment {
    private static int game_id;
    private TextView summary_text;
    private TextView developers_list;
    private TextView publishers_list;
    private TextView genres_list;
    private TextView platforms_list;

    public SummaryFragment(int game_id) {
        this.game_id = game_id;
    }

    public static SummaryFragment newInstance() {
        return new SummaryFragment(game_id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        summary_text = view.findViewById(R.id.summary_text);
        developers_list = view.findViewById(R.id.developers_list);
        publishers_list = view.findViewById(R.id.publishers_list);
        genres_list = view.findViewById(R.id.genres_list);
        platforms_list = view.findViewById(R.id.platforms_list);

        DataSource.getGamesSummary(game_id, summary_text, developers_list, publishers_list, platforms_list);

        return view;
    }
}