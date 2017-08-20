package com.example.ahmedsalamony.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.adapter.RecyclerAdapter;
import com.example.ahmedsalamony.mercato.models.PointsModel;
import com.example.ahmedsalamony.mercato.models.ProductsCategoriesModel;
import com.example.ahmedsalamony.mercato.tools.APIManager;
import com.example.ahmedsalamony.mercato.ui.LoadingManager;
import com.example.ahmedsalamony.mercato.viewholder.CategoriesHolder;
import com.example.ahmedsalamony.mercato.viewholder.pointsHolder;

import java.util.List;

public class MercatoPoints extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LoadingManager loadingManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercato_points);
        loadingManager = new LoadingManager(this, findViewById(R.id.progressBar));

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        getPoints();
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
