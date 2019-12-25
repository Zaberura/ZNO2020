package com.example.zno2020.ui.manual;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.zno2020.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout linearLayout;
    public TextView title;
    public TextView description;
    public ImageView imageView;

    MyViewHolder(View itemView) {
        super(itemView);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        imageView = (ImageView) itemView.findViewById(R.id.imageViewStar);
    }


}
