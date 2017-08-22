package com.example.ahmedsalamony.mercato.adapter;

/**
 * Created by ahmed on 8/22/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.models.StaticReviewModel;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.List;

public class StaticReviewAdapter extends RecyclerView.Adapter<StaticReviewAdapter.MyViewHolder> {



    private List<StaticReviewModel> reviewModels;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_dept;
        SimpleRatingBar ratingBar;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_dept = (TextView) itemView.findViewById(R.id.textView_dept);
            ratingBar=(SimpleRatingBar)itemView.findViewById(R.id.rating);
        }
    }


    public StaticReviewAdapter(List<StaticReviewModel> reviewModels) {
        this.reviewModels = reviewModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_add_review, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        StaticReviewModel reviewModel = reviewModels.get(position);
        holder.tv_dept.setText(reviewModel.getDeparts());



    }

    @Override
    public int getItemCount() {
        return reviewModels.size();
    }
}