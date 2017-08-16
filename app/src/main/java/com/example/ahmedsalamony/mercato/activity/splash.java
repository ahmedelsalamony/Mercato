package com.example.ahmedsalamony.mercato.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;


import com.example.ahmedsalamony.mercato.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    Intent mainIntent;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

/*        if (LogInManager.getUserSession(splash.this).equals("")) {




            APIManager.AddSession(splash.this, new APIManager.ResponseListener<SessionModel>() {
                @Override
                public void done(SessionModel dataModel) {
                    if (dataModel.getSuccess()) {
                        LogInManager.setUserSession(splash.this, dataModel.getData().getSession());
                        Log.e("Sucsses", "Sucsses");

                    }
                    flag = 1;
                }

                @Override
                public void failed(boolean fromConnection) {

                }
            });
        }else {
            flag=1;
        }*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
             /*   if (flag == 1) {

                    if (LogInManager.isUserLoggedIn(splash.this, false, false)) {
                        mainIntent = new Intent(splash.this, MainScreen.class);
                    } else {
                        mainIntent = new Intent(splash.this, LoginRegister.class);
                    }*/

                    // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                    //   mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    mainIntent=new Intent(splash.this,LoginScan.class);
                    splash.this.startActivity(mainIntent);
                    splash.this.finish();
                //}


            }
        }, SPLASH_DISPLAY_LENGTH);



    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
