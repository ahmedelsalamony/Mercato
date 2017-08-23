package com.apps.square.mercato.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.apps.square.mercato.R;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

/**
 * Created by Ahmed Salamony on 8/21/2017.
 */

public class AddReviewHolder extends RecyclerView.ViewHolder {
    SimpleRatingBar ratingBar;
    TextView tv_dept;

    public SimpleRatingBar getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(SimpleRatingBar ratingBar) {
        this.ratingBar = ratingBar;
    }

    public TextView getTv_dept() {
        return tv_dept;
    }

    public void setTv_dept(TextView tv_dept) {
        this.tv_dept = tv_dept;
    }

    public AddReviewHolder(View itemView) {
        super(itemView);

        tv_dept=(TextView)itemView.findViewById(R.id.textView_dept);
        ratingBar=(SimpleRatingBar)itemView.findViewById(R.id.rating);

    }
}
