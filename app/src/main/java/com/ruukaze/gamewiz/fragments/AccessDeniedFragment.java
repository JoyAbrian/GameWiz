package com.ruukaze.gamewiz.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ruukaze.gamewiz.LoginActivity;
import com.ruukaze.gamewiz.R;

public class AccessDeniedFragment extends Fragment {
    private Button signup_button;

    public AccessDeniedFragment() {
        // Required empty public constructor
    }

    public static AccessDeniedFragment newInstance() {
        return new AccessDeniedFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_access_denied, container, false);

        signup_button = view.findViewById(R.id.signup_button);
        signup_button.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), LoginActivity.class);
            startActivity(intent);
        });

        return view;
    }
}