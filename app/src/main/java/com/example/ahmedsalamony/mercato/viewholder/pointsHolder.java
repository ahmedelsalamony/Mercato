package com.example.ahmedsalamony.mercato.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ahmedsalamony.mercato.R;

/**
 * Created by Ahmed Salamony on 8/20/2017.
 */

public class pointsHolder extends RecyclerView.ViewHolder {
    TextView number_points,description_points;

    public TextView getNumber_points() {
        return number_points;
    }

    public void setNumber_points(TextView number_points) {
        this.number_points = number_points;
    }

    public TextView getDescription_points() {
        return description_points;
    }

    public void setDescription_points(TextView description_points) {
        this.description_points = description_points;
    }

    public pointsHolder(View itemView) {
        super(itemView);
        number_points=(TextView)itemView.findViewById(R.id.number_points);
        description_points=(TextView)itemView.findViewById(R.id.description_points);
    }
}
