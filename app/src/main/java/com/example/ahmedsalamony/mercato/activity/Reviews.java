package com.example.ahmedsalamony.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.ahmedsalamony.mercato.R;

public class Reviews extends AppCompatActivity {
    RatingBar rb_drinks, rb_service, rb_meals, rb_clean, rb_team;
    EditText et_comment;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        rb_drinks=(RatingBar)findViewById(R.id.ratingBar_drinks);
        rb_meals=(RatingBar)findViewById(R.id.ratingBar_Meals);
        rb_service=(RatingBar)findViewById(R.id.ratingBar_service);
        rb_clean=(RatingBar)findViewById(R.id.ratingBar_clean);
        rb_team=(RatingBar)findViewById(R.id.ratingBar_team);
        et_comment=(EditText)findViewById(R.id.comment);
        btn_submit=(Button)findViewById(R.id.btn_submit);


    }
}
