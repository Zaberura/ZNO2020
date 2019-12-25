package com.example.zno2020.ui.tests;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.zno2020.App;
import com.example.zno2020.MainActivity;
import com.example.zno2020.R;
import com.example.zno2020.database.AppDatabase;
import com.example.zno2020.database.TestsDao;
import com.example.zno2020.ui.manual.ManualTests;

public class TestsPageFragment extends Fragment {

    final static int TESTS_AMOUNT = 19;

    Button dailyTestsBtn;
    Button usualTests;
    Button allTestsBtn;

    AppDatabase database;
    TestsDao testsDao;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_tests, container, false);

        dailyTestsBtn = root.findViewById(R.id.dailyTests);
        usualTests = root.findViewById(R.id.usualTests);
        allTestsBtn = root.findViewById(R.id.allTests);

        database = App.getInstance().getDatabase();
        testsDao = database.testsDao();

        dailyTestsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.navController.navigate(R.id.testing_fragment);
            }
        });

        usualTests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestingFragment.setCurrentTestId(Math.round(Math.random()*TESTS_AMOUNT + 1));
                MainActivity.navController.navigate(R.id.testing_fragment);
            }
        });

        allTestsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManualTests.setDataset(testsDao.getAll());
                MainActivity.navController.navigate(R.id.manualTests);
            }
        });



        return root;
    }
}