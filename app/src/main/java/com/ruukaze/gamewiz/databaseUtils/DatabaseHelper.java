package com.ruukaze.gamewiz.databaseUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.ruukaze.gamewiz.R;
import com.ruukaze.gamewiz.models.Community;
import com.ruukaze.gamewiz.models.Library;
import com.ruukaze.gamewiz.models.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "GameWiz.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String TABLE_LIBRARY = "library";
    public static final String TABLE_COMMUNITIES = "communities";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE AND INSERT DUMMY USERS
        db.execSQL("CREATE TABLE " + TABLE_USERS + " (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT UNIQUE, dateOfRegister TEXT, avatar INTEGER, community_id INTEGER ,fullname TEXT, email TEXT UNIQUE, password TEXT)");
        uploadDummyUsers(db);

        // CREATE AND INSERT DUMMY LIBRARY
        db.execSQL("CREATE TABLE " + TABLE_LIBRARY + " (id INTEGER PRIMARY KEY AUTOINCREMENT, user_id INTEGER, game_id INTEGER, type TEXT, FOREIGN KEY (user_id) REFERENCES users(id))");
        uploadDummyLibraries(db);

        // CREATE AND INSERT DUMMY COMMUNITIES
        db.execSQL("CREATE TABLE " + TABLE_COMMUNITIES + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE, description TEXT, icon INTEGER, leader_id INTEGER UNIQUE, FOREIGN KEY (leader_id) REFERENCES users(id))");
        uploadDummyCommunities(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIBRARY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMUNITIES);
        onCreate(db);
    }

    private void uploadDummyUsers(SQLiteDatabase db) {
        ArrayList<User> users = DummyDataGenerator.dummyUsers;
        for (User user : users) {
            ContentValues values = new ContentValues();
            values.put("id", user.getId());
            values.put("username", user.getUsername());
            values.put("dateOfRegister", user.getDateOfRegister());
            values.put("avatar", user.getAvatar());
            values.put("community_id", user.getCommunity_id());
            values.put("fullname", user.getFullname());
            values.put("email", user.getEmail());
            values.put("password", user.getPassword());
            db.insert(TABLE_USERS, null, values);
        }
    }

    private void uploadDummyLibraries(SQLiteDatabase db) {
        ArrayList<Library> libraries = DummyDataGenerator.dummyLibraries;
        for (Library library : libraries) {
            ContentValues values = new ContentValues();
            values.put("id", library.getId());
            values.put("user_id", library.getUser_id());
            values.put("game_id", library.getGame_id());
            values.put("type", library.getType());
            db.insert(TABLE_LIBRARY, null, values);
        }
    }

    private void uploadDummyCommunities(SQLiteDatabase db) {
        ArrayList<Community> communities = DummyDataGenerator.dummyCommunities;
        for (Community community : communities) {
            ContentValues values = new ContentValues();
            values.put("id", community.getId());
            values.put("name", community.getName());
            values.put("description", community.getDescription());
            values.put("icon", community.getIcon());
            values.put("leader_id", community.getLeader_id());
            db.insert(TABLE_COMMUNITIES, null, values);
        }
    }

    private String getCurrentDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public void insertUser(String username, String fullname, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("dateOfRegister", getCurrentDateTime());
        values.put("avatar", R.drawable.avatar_4);
        values.put("community_id", 0);
        values.put("fullname", fullname);
        values.put("email", email);
        values.put("password", password);
        db.insert(TABLE_USERS, null, values);
        db.close();
    }


}
