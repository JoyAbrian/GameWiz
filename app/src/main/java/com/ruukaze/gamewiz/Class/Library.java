package com.ruukaze.gamewiz.Class;

public class Library {
    private int id;
    private int user_id;
    private int game_id;
    private int type;

    public Library(int id, int user_id, int game_id, int type) {
        this.id = id;
        this.user_id = user_id;
        this.game_id = game_id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
