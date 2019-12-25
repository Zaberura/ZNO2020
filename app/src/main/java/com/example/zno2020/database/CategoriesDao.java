package com.example.zno2020.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoriesDao {

    // NOTE: Database was created just for app be able to run
    // It does not separated in categories
    // Just a model of database, to show how should it seem and how app work

    @Query("SELECT * FROM categories ORDER BY is_stared DESC")
    List<Categories> getAll();

    @Query("SELECT * FROM categories WHERE id = :id")
    Categories getById(long id);

    @Insert
    void insert(Categories categories);

    @Update
    void update(Categories categories);

    @Delete
    void delete(Categories categories);
}
