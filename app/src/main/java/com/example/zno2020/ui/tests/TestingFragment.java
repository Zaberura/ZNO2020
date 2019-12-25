package com.example.zno2020.ui.tests;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.zno2020.App;
import com.example.zno2020.R;
import com.example.zno2020.database.AppDatabase;
import com.example.zno2020.database.Tests;
import com.example.zno2020.database.TestsDao;

import java.io.IOException;

public class TestingFragment extends Fragment {

    final String TAG = "QWERTY";

    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;
    private TextView questionView;

    private AppDatabase database;
    private TestsDao testsDao;
    private Tests currentTest;
    private static long currentTestId;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.testing_fragment, container, false);

        database = App.getInstance().getDatabase();
        testsDao = database.testsDao();
        currentTest = testsDao.getById(1);

        questionView = root.findViewById(R.id.questionText);
        answerBtn1 = root.findViewById(R.id.answerBtn1);
        answerBtn2 = root.findViewById(R.id.answerBtn2);
        answerBtn3 = root.findViewById(R.id.answerBtn3);
        answerBtn4 = root.findViewById(R.id.answerBtn4);

        nextTest();

        answerBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrueAnswer(v)){
                    nextTest();
                }
                playSound(isTrueAnswer(v));
            }
        });
        answerBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrueAnswer(v)){
                    nextTest();
                }
                playSound(isTrueAnswer(v));
            }
        });
        answerBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrueAnswer(v)){
                    nextTest();
                }
                playSound(isTrueAnswer(v));
            }
        });
        answerBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isTrueAnswer(v)){
                    nextTest();
                }
                playSound(isTrueAnswer(v));
            }
        });

        return root;
    }

    private boolean isTrueAnswer(View view){
        switch (this.currentTest.right_answer_key){
            case 1 :
                if(view.getId() == R.id.answerBtn1){return true;}
                break;
            case 2 :
                if(view.getId() == R.id.answerBtn2){return true;}
                break;
            case 3 :
                if(view.getId() == R.id.answerBtn3){return true;}
                break;
            case 4 :
                if(view.getId() == R.id.answerBtn4){return true;}
                break;
        }
        return false;
    }

    private void nextTest(){
        Log.d(TAG, "nextTest: You have passed this test!!!");
        currentTest = testsDao.getById(++currentTestId);
        try {
            bindText();
        }catch (Exception e){
            currentTestId = 0;
            currentTest = testsDao.getById(++currentTestId);
            bindText();
        }

    }

    private void bindText(){
        questionView.setText(currentTest.question);
        answerBtn1.setText(currentTest.answer1);
        answerBtn2.setText(currentTest.answer2);
        answerBtn3.setText(currentTest.answer3);
        answerBtn4.setText(currentTest.answer4);
    }

    public static void setCurrentTestId(long id){
        currentTestId = id;
    }

    private void playSound(Boolean isComplete){
        final String LOG_TAG = "myLogs";
        final int MAX_STREAMS = 5;

        SoundPool sp;
        int soundIdComplete;
        int soundIdError;

        sp = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);

        soundIdComplete = sp.load(getContext(), R.raw.test_complete_sound, 1);
        soundIdError = sp.load(getContext(), R.raw.test_error_sound, 1);

        if(isComplete) {
            sp.play(soundIdComplete, 1, 1, 0, 0, 1);
        } else {
            sp.play(soundIdError, 1, 1, 0,0,1);
        }
    }
}
