package com.apps.square.mercato.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.apps.square.mercato.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    Intent mainIntent;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    mainIntent=new Intent(splash.this,HomeActivity.class);
                    splash.this.startActivity(mainIntent);
                    splash.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
