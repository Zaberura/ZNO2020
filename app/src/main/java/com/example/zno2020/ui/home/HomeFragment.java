package com.example.zno2020.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.zno2020.App;
import com.example.zno2020.MainActivity;
import com.example.zno2020.R;
import com.example.zno2020.database.AppDatabase;
import com.example.zno2020.database.Categories;
import com.example.zno2020.database.CategoriesDao;
import com.example.zno2020.database.Tests;
import com.example.zno2020.database.TestsDao;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button goToTestsBtn;

    AppDatabase database;
    TestsDao testsDao;
    CategoriesDao categoriesDao;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        goToTestsBtn = root.findViewById(R.id.goToTasksBtn);
        goToTestsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.navController.navigate(R.id.testing_fragment);
            }
        }); 

        return root;
    }
}