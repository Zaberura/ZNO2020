package com.example.zno2020.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Tests.class, Categories.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TestsDao testsDao();
    public abstract CategoriesDao categoriesDao();
}
