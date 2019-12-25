package com.example.zno2020.ui.manual;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zno2020.App;
import com.example.zno2020.MainActivity;
import com.example.zno2020.R;
import com.example.zno2020.database.AppDatabase;
import com.example.zno2020.database.Categories;
import com.example.zno2020.database.CategoriesDao;
import com.example.zno2020.database.TestsDao;

import java.util.ArrayList;
import java.util.List;

public class ManualCatalogFragment extends Fragment {

    private Button movaBtn;
    private Button literatureBtn;
    private RecyclerView recyclerView;


    AppDatabase database;
    CategoriesDao categoriesDao;
    TestsDao testsDao;
    List<Categories> mCategories;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater
                .inflate(R.layout.fragment_manual_catalog, container, false);

        database = App.getInstance().getDatabase();
        categoriesDao = database.categoriesDao();
        testsDao = database.testsDao();

        mCategories = new ArrayList<>();

        movaBtn = root.findViewById(R.id.MovaBtn);
        literatureBtn = root.findViewById(R.id.LiteratureBtn);
        recyclerView = root.findViewById(R.id.SelectedCategoriesRecyclerView);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        movaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManualTests.setDataset(testsDao.getMova());
                MainActivity.navController.navigate(R.id.manualTests);
            }
        });
        literatureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManualTests.setDataset(testsDao.getLiterature());
                MainActivity.navController.navigate(R.id.manualTests);
            }
        });

        showStared(recyclerView);
    }

    private void showStared(RecyclerView rv){
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager layoutManager;

        mCategories.addAll(categoriesDao.getAll());
        rv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);
        mAdapter = new MyCategoriesAdaptor(mCategories, getContext());
        rv.setAdapter(mAdapter);
    }
}