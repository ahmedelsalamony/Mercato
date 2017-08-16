package com.example.ahmedsalamony.mercato.ui;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ahmedsalamony.mercato.R;


public class LoadingManager {

    private ProgressBar loadingProgressBar;

    public LoadingManager(Context context, View loadingProgress){
        loadingProgressBar =(ProgressBar)loadingProgress;
        loadingProgressBar.getIndeterminateDrawable().setColorFilter(context.getResources().getColor(R.color.colorPrimary), android.graphics.PorterDuff.Mode.SRC_ATOP);
    }

    public void showLoadingProgress(){
        loadingProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoadingProgress(){
        loadingProgressBar.setVisibility(View.GONE);
    }

}
