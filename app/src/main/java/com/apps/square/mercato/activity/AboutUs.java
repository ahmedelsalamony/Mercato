package com.apps.square.mercato.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.fragments.fragment_menu;

public class AboutUs extends AppCompatActivity {
    public static View head;
    public static TextView texthead;
    private Class currentFragmentClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        head=findViewById(R.id.menu);
        texthead=(TextView)findViewById(R.id.headtext);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(new fragment_menu());
            }
        });
    }

    private void openFragment(Fragment fragment) {
        if (currentFragmentClass != fragment.getClass()) {
            currentFragmentClass = fragment.getClass();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_about_us, fragment)
                    .commit();
        }
    }
}
