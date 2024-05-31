package com.ruukaze.gamewiz.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.models.Game;

public class SummaryFragment extends Fragment {
    private static int game_id;

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
        return view;
    }
}