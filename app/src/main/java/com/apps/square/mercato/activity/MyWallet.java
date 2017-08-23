package com.apps.square.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.adapter.RecyclerAdapter;
import com.apps.square.mercato.models.PointsModel;
import com.apps.square.mercato.tools.APIManager;
import com.apps.square.mercato.ui.LoadingManager;
import com.apps.square.mercato.viewholder.pointsHolder;

import java.util.List;

public class MyWallet extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LoadingManager loadingManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);

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
