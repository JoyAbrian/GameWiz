package com.ruukaze.gamewiz.databaseUtils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ruukaze.gamewiz.models.Community;
import com.ruukaze.gamewiz.models.User;

import java.util.ArrayList;

public class DBDataSource {
    private static DatabaseHelper dbHelper;

    public static void initialize(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users ORDER BY id DESC LIMIT 15", null);
        if (cursor.moveToFirst()) {
            do {
                // Get user data
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                String dateOfRegister = cursor.getString(cursor.getColumnIndexOrThrow("dateOfRegister"));
                int avatar = cursor.getInt(cursor.getColumnIndexOrThrow("avatar"));
                int community_id = cursor.getInt(cursor.getColumnIndexOrThrow("community_id"));
                String fullname = cursor.getString(cursor.getColumnIndexOrThrow("fullname"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));

                users.add(new User(id, username, dateOfRegister, avatar, community_id, fullname, email, password));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return users;
    }

    public static ArrayList<Community> getCommunities() {
        ArrayList<Community> communities = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM communities ORDER BY id DESC LIMIT 15", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                int icon = cursor.getInt(cursor.getColumnIndexOrThrow("icon"));
                int leader_id = cursor.getInt(cursor.getColumnIndexOrThrow("leader_id"));

                communities.add(new Community(id, name, description, icon, leader_id));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return communities;
    }
}
