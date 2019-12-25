package com.example.zno2020;

import android.app.Application;

import androidx.room.Room;

import com.example.zno2020.database.AppDatabase;

public class App extends Application {

    final String DB_NAME = "tests.db";

    public static App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance(){
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
