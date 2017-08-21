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

import java.util.List;

public class StaticReviewAdapter extends RecyclerView.Adapter<StaticReviewAdapter.MyViewHolder> {



    private List<StaticReviewModel> reviewModels;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView star1, star2, star3, star4, star5;
        TextView tv_dept;

        public MyViewHolder(View itemView) {
            super(itemView);
            star1 = (ImageView) itemView.findViewById(R.id.star1);
            star2 = (ImageView) itemView.findViewById(R.id.star2);
            star3 = (ImageView) itemView.findViewById(R.id.star3);
            star4 = (ImageView) itemView.findViewById(R.id.star4);
            star5 = (ImageView) itemView.findViewById(R.id.star5);
            tv_dept = (TextView) itemView.findViewById(R.id.textView_dept);
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

        holder.star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.star1.setImageResource(R.drawable.star_fill);
            }
        });

    }

    @Override
    public int getItemCount() {
        return reviewModels.size();
    }
}