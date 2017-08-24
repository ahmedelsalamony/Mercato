package com.apps.square.mercato.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.fragments.fragment_menu;

public class TotalReviews extends AppCompatActivity {
    RatingBar rb_drinks, rb_service, rb_meals, rb_clean, rb_team;
    Button btn_post;
    public static View head;
    public static TextView texthead;
    private Class currentFragmentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_reviews);
        btn_post=(Button)findViewById(R.id.btn_post);

        head=findViewById(R.id.menu);
        texthead=(TextView)findViewById(R.id.headtext);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(new fragment_menu());
            }
        });

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TotalReviews.this,Reviews.class);
                startActivity(i);
            }
        });
//test
    }

    private void openFragment(Fragment fragment) {
        if (currentFragmentClass != fragment.getClass()) {
            currentFragmentClass = fragment.getClass();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_reviews_totla, fragment)
                    .commit();
        }
    }
}
