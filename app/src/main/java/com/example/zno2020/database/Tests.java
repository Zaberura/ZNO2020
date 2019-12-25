package com.example.zno2020.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tests {

    @PrimaryKey
    public int id;

    public String question;

    public String answer1;

    public String answer2;

    public String answer3;

    public String answer4;

    public int right_answer_key;

    public int categoty_key;

    public boolean is_stared;

    public Tests(int id){
        this.id = id;
        question = "This is question number: " + id;
        answer1 = "This is first answer option number: " + id;
        answer2 = "This is second answer option number: " + id;
        answer3 = "This is third answer option number: " + id;
        answer4 = "This is fourth answer option number: " + id;
        right_answer_key = (int) Math.random()*3+1;
        categoty_key = (int) Math.random()*20+1;
        if(id %2 == 0) is_stared = false;
        else is_stared = true;
    }
}
