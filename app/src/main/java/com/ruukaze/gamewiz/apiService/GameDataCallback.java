package com.ruukaze.gamewiz.apiService;

import com.ruukaze.gamewiz.models.Game;

import java.util.ArrayList;

public interface GameDataCallback {
    void onSuccess(ArrayList<Game> games);
    void onFailure(Throwable t);
}
