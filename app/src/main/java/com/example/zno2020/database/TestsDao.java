package com.example.zno2020.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TestsDao {

    // NOTE: Database was created just for app be able to run
    // It does not separated in categories
    // Just a model of database, to show how should it seem and how app work

    @Query("SELECT * FROM tests ORDER BY is_stared DESC")
    List<Tests> getAll();

    @Query("SELECT * FROM tests ORDER BY is_stared DESC")
    List<Tests> getMova();

    @Query("SELECT * FROM tests ORDER BY is_stared DESC")
    List<Tests> getLiterature();

    @Query("SELECT * FROM tests WHERE categoty_key = :categoty_key ORDER BY is_stared DESC")
    List<Tests> getByCategory(int categoty_key);

    @Query("SELECT * FROM tests WHERE id = :id")
    Tests getById(long id);

    @Insert
    void insert(Tests tests);

    @Update
    void update(Tests tests);

    @Delete
    void delete(Tests tests);
}
