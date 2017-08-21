package com.example.ahmedsalamony.mercato.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmedsalamony.mercato.R;

/**
 * Created by Ahmed Salamony on 8/21/2017.
 */

public class AddReviewHolder extends RecyclerView.ViewHolder {
    ImageView star1,star2,star3,star4,star5;
    TextView tv_dept;

    public ImageView getStar1() {
        return star1;
    }

    public void setStar1(ImageView star1) {
        this.star1 = star1;
    }

    public ImageView getStar2() {
        return star2;
    }

    public void setStar2(ImageView star2) {
        this.star2 = star2;
    }

    public ImageView getStar3() {
        return star3;
    }

    public void setStar3(ImageView star3) {
        this.star3 = star3;
    }

    public ImageView getStar4() {
        return star4;
    }

    public void setStar4(ImageView star4) {
        this.star4 = star4;
    }

    public ImageView getStar5() {
        return star5;
    }

    public void setStar5(ImageView star5) {
        this.star5 = star5;
    }

    public TextView getTv_dept() {
        return tv_dept;
    }

    public void setTv_dept(TextView tv_dept) {
        this.tv_dept = tv_dept;
    }

    public AddReviewHolder(View itemView) {
        super(itemView);
        star1=(ImageView)itemView.findViewById(R.id.star1);
        star2=(ImageView)itemView.findViewById(R.id.star2);
        star3=(ImageView)itemView.findViewById(R.id.star3);
        star4=(ImageView)itemView.findViewById(R.id.star4);
        star5=(ImageView)itemView.findViewById(R.id.star5);
        tv_dept=(TextView)itemView.findViewById(R.id.textView_dept);

    }
}
