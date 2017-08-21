package com.example.ahmedsalamony.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ahmedsalamony.mercato.R;
import com.willy.ratingbar.BaseRatingBar;
import com.willy.ratingbar.ScaleRatingBar;

import static com.example.ahmedsalamony.mercato.R.drawable.ratingbar;

public class Main2Activitytt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activitytt);


    /*    ScaleRatingBar ratingBar = new ScaleRatingBar(this);
        ratingBar.setNumStars(5);
        ratingBar.setRating(3);
        ratingBar.setStarPadding(10);
        ratingbar.setTouchable(true);
        ratingbar.setClearRatingEnabled(true);
        ratingBar.setEmptyDrawableRes(R.drawable.start_empty);
        ratingBar.setFilledDrawableRes(R.drawable.start_empty);
        ratingBar.setOnRatingChangeListener(new BaseRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(BaseRatingBar ratingBar, int rating) {
                Log.e(TAG, "onRatingChange: " + rating);
            }
        });*/
    }
}
