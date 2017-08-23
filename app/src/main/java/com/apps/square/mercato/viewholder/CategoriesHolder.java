package com.apps.square.mercato.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.square.mercato.R;

/**
 * Created by ahmed on 8/19/2017.
 */

public class CategoriesHolder extends RecyclerView.ViewHolder {
    ImageView category_img;
    TextView category_name;

    public ImageView getCategory_img() {
        return category_img;
    }

    public void setCategory_img(ImageView category_img) {
        this.category_img = category_img;
    }

    public TextView getCategory_name() {
        return category_name;
    }

    public void setCategory_name(TextView category_name) {
        this.category_name = category_name;
    }

    public CategoriesHolder(View itemView) {
        super(itemView);
        category_img = (ImageView) itemView.findViewById(R.id.category_img);
        category_name=(TextView) itemView.findViewById(R.id.category_name);
    }


    }
