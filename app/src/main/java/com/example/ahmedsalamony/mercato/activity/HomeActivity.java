package com.example.ahmedsalamony.mercato.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.fragments.HomeScreen;
import com.example.ahmedsalamony.mercato.fragments.fragment_menu;

public class HomeActivity extends AppCompatActivity {
    public static View head;
    public static TextView texthead;
    private Class currentFragmentClass;
    private boolean isMainFragment;
    int back = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        head=findViewById(R.id.menu);
        texthead=(TextView)findViewById(R.id.headtext);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(new fragment_menu());
            }
        });
        if (getIntent().getExtras() != null) {


            if (getIntent().getIntExtra("where",0)==1) {
                openFragment(new fragment_menu());
                isMainFragment = false;
            }
        }
        else {

            isMainFragment = true;
            openFragment(new HomeScreen());
        }
        openFragment(new HomeScreen());
    }

    private void openFragment(Fragment fragment) {
        if (currentFragmentClass != fragment.getClass()) {
            currentFragmentClass = fragment.getClass();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_home2, fragment)
                    .commit();
        }
    }
    @Override
    public void onBackPressed() {

            if (back == 0) {
                Toast.makeText(HomeActivity.this, R.string.leave, Toast.LENGTH_LONG).show();
                back++;
            } else if (back == 1) {
                moveTaskToBack(true);
            }
        }
}
