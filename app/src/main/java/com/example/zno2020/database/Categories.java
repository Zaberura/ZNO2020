package com.example.zno2020.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categories {

    @PrimaryKey
    public long id;

    public  String category_name;

    public boolean is_stared;

    public Categories(long id){
        this.category_name = "This is our "+ id +" category";
        this.id = id;
        if(id%2==0){
            is_stared =true;
        } else is_stared = false;
    }

}
