package com.example.zno2020.ui.manual;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zno2020.App;
import com.example.zno2020.R;
import com.example.zno2020.database.AppDatabase;
import com.example.zno2020.database.Tests;
import com.example.zno2020.database.TestsDao;

import java.util.List;

public class MyTestsAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Tests> mQuestions;
    Context context;
    AppDatabase database;
    TestsDao testsDao;

    public MyTestsAdapter(List<Tests> mQuestions, Context context) {
        this.mQuestions = mQuestions;
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
        testsDao = database.testsDao();

        holder.title.setText(mQuestions.get(position).question);
        if(mQuestions.get(position).is_stared){
            holder.imageView.setImageResource(R.drawable.ic_star);
        } else {
            holder.imageView.setImageResource(R.drawable.ic_empty_star);
        }
        switch (mQuestions.get(position).right_answer_key){
            case 1:
                holder.description.setText(mQuestions.get(position).answer1);
                break;
            case 2:
                holder.description.setText(mQuestions.get(position).answer2);
                break;
            case 3:
                holder.description.setText(mQuestions.get(position).answer3);
                break;
            case 4:
                holder.description.setText(mQuestions.get(position).answer4);
                break;
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tests test = mQuestions.get(position);
                test.is_stared = !test.is_stared;
                testsDao.update(test);
                if(mQuestions.get(position).is_stared){
                    holder.imageView.setImageResource(R.drawable.ic_star);
                } else {
                    holder.imageView.setImageResource(R.drawable.ic_empty_star);
                }
            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }
}