package com.ruukaze.gamewiz.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruukaze.gamewiz.R;

public class CommunityFragment extends Fragment {
    public CommunityFragment() {
        // Required empty public constructor
    }

    public static CommunityFragment newInstance() {
        return new CommunityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);



        return view;
    }
}