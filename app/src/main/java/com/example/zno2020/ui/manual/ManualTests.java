package com.example.zno2020.ui.manual;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zno2020.App;
import com.example.zno2020.R;
import com.example.zno2020.database.AppDatabase;
import com.example.zno2020.database.CategoriesDao;
import com.example.zno2020.database.Tests;
import com.example.zno2020.database.TestsDao;

import java.util.ArrayList;
import java.util.List;

public class ManualTests extends Fragment {
    final String TAG = "QWERTY";

    private View root;
    private RecyclerView recyclerView;
    private AppDatabase database;
    private CategoriesDao categoriesDao;
    private TestsDao testsDao;
    private static List<Tests> mDataset;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_manual_tests, container, false);
        recyclerView = root.findViewById(R.id.testListRecyclerView);
        database = App.getInstance().getDatabase();
        categoriesDao = database.categoriesDao();
        testsDao = database.testsDao();
        
        getTests(recyclerView);
        
        return root;
    }
    private void getTests(RecyclerView rv) {
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager layoutManager;

        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        mAdapter = new MyTestsAdapter(mDataset, getContext());
        rv.setAdapter(mAdapter);
    }

    public static void setDataset( List<Tests> dataset){
        mDataset = dataset;
    }
}
