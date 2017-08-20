package com.example.ahmedsalamony.mercato.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.adapter.SlidingImage_Adapter;
import com.example.ahmedsalamony.mercato.models.MenuModel;
import com.example.ahmedsalamony.mercato.tools.APIManager;
import com.example.ahmedsalamony.mercato.ui.LoadingManager;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    List<MenuModel.DataModel> data;
    private List<String> ImagesArray = new ArrayList<String>();
    LoadingManager loadingManager;
    public static int height,width;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
         height = displayMetrics.heightPixels;
         width = displayMetrics.widthPixels;

        loadingManager = new LoadingManager(this, findViewById(R.id.progressBar));
        loadingManager.showLoadingProgress();
        filldata();
    }

    private void filldata() {
        APIManager.getOurMenu(this, new APIManager.ResponseListener<MenuModel>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void done(final MenuModel dataModel) {
                Log.e("ssss",dataModel.getApi_message()  + "");
                if (dataModel.getApi_status()==1) {
                    loadingManager.hideLoadingProgress();

                    data  = new ArrayList<MenuModel.DataModel>();
                    data =  dataModel.getData();


                    init(data);

                }
            }

            @Override
            public void failed(boolean fromConnection) {

            }

        });
    }

    private void init(final List<MenuModel.DataModel> data) {


        for(int i=0;i<data.size();i++) {
            ImagesArray.add(data.get(i).getPhoto());
            Log.e("pager", ImagesArray.get(i) + "");
        }
        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(this,ImagesArray));


        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =data.size();

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }
}
