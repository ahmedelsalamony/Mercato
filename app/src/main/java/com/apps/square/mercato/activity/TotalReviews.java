package com.apps.square.mercato.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.apps.square.mercato.R;

public class TotalReviews extends AppCompatActivity {
    RatingBar rb_drinks, rb_service, rb_meals, rb_clean, rb_team;
    Button btn_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_reviews);
        btn_post=(Button)findViewById(R.id.btn_post);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TotalReviews.this,Reviews.class);
                startActivity(i);
            }
        });
//test
    }
}
