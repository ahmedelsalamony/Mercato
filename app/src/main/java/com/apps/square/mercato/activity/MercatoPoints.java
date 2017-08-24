package com.apps.square.mercato.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.adapter.RecyclerAdapter;
import com.apps.square.mercato.fragments.fragment_menu;
import com.apps.square.mercato.models.PointsModel;
import com.apps.square.mercato.tools.APIManager;
import com.apps.square.mercato.ui.LoadingManager;
import com.apps.square.mercato.viewholder.pointsHolder;

import java.util.List;

public class MercatoPoints extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LoadingManager loadingManager;

    public static View head;
    public static TextView texthead;
    private Class currentFragmentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercato_points);
        loadingManager = new LoadingManager(this, findViewById(R.id.progressBar));

        ImageView img=(ImageView)findViewById(R.id.close);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MercatoPoints.this,HomeActivity.class);
                startActivity(i);
                finish();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        getPoints();

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
                    .replace(R.id.activity_mercato_points, fragment)
                    .commit();
        }
    }
    public void getPoints() {
        APIManager.getPoints(this, new APIManager.ResponseListener<PointsModel>() {
            @Override
            public void done(PointsModel dataModel) {
                if (dataModel.getApi_status()==1) {
                    loadingManager.hideLoadingProgress();
                    adddata(dataModel.getData());

                    }
                }
            @Override
            public void failed(boolean fromConnection) {

            }
        });
    }

    public void adddata(final List<PointsModel.DataModel> data) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(data, R.layout.row_about_points, pointsHolder.class,
                new RecyclerAdapter.AdapterInterface<PointsModel.DataModel, pointsHolder>() {
                    @Override
                    public void fillData(final PointsModel.DataModel dataModel, final pointsHolder viewHolder)
                    {
                        viewHolder.getNumber_points().setText(dataModel.getPoints()+"");
                        viewHolder.getDescription_points().setText(dataModel.getDescription());

                    }});
        recyclerView.setAdapter(recyclerAdapter);
    }
}
