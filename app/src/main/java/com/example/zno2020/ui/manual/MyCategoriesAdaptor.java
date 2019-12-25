package com.example.zno2020.ui.manual;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zno2020.App;
import com.example.zno2020.MainActivity;
import com.example.zno2020.R;
import com.example.zno2020.database.AppDatabase;
import com.example.zno2020.database.Categories;
import com.example.zno2020.database.CategoriesDao;
import com.example.zno2020.database.TestsDao;

import java.util.List;

public class MyCategoriesAdaptor extends RecyclerView.Adapter<MyViewHolder> {

    private List<Categories> mCategories;
    Context context;
    AppDatabase database;
    CategoriesDao categoriesDao;
    TestsDao testsDao;

    public MyCategoriesAdaptor(List<Categories> mCategories, Context context) {
        this.mCategories = mCategories;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_manual_catalog, parent,false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        database = App.getInstance().getDatabase();
        categoriesDao = database.categoriesDao();
        testsDao = database.testsDao();

        holder.title.setText(mCategories.get(position).category_name);
        if(mCategories.get(position).is_stared){
            holder.imageView.setImageResource(R.drawable.ic_star);
        }else {
            holder.imageView.setImageResource(R.drawable.ic_empty_star);
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Categories category = mCategories.get(position);
                category.is_stared = !category.is_stared;
                categoriesDao.update(category);
                if(mCategories.get(position).is_stared){
                    holder.imageView.setImageResource(R.drawable.ic_star);
                }else {
                    holder.imageView.setImageResource(R.drawable.ic_empty_star);
                }
            }
        });
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManualTests.setDataset(testsDao.getByCategory(position));
                MainActivity.navController.navigate(R.id.manualTests);
            }
        });
        holder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManualTests.setDataset(testsDao.getByCategory(position));
                MainActivity.navController.navigate(R.id.manualTests);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }
}