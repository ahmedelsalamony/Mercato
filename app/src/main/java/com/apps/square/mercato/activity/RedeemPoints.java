package com.apps.square.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.adapter.ImageAdapter;
import com.apps.square.mercato.models.PointsModel;
import com.apps.square.mercato.tools.APIManager;
import com.apps.square.mercato.ui.LoadingManager;

import java.util.ArrayList;
import java.util.List;

public class RedeemPoints extends AppCompatActivity {
    GridView grid;
    private LoadingManager loadingManager;
    List<String> points_text;
    List<Integer> img_sources;
    TextView userpoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_points);
        loadingManager = new LoadingManager(this, findViewById(R.id.progressBar));
        userpoints=(TextView)findViewById(R.id.userpoints);

        img_sources=new ArrayList<>();
        points_text=new ArrayList<>();
        getPoints();


    }

    public void getPoints() {
        APIManager.getPoints(this, new APIManager.ResponseListener<PointsModel>() {
            @Override
            public void done(PointsModel dataModel) {
                if (dataModel.getApi_status() == 1) {
                    loadingManager.hideLoadingProgress();
                    userpoints.setText(dataModel.getUser_points());
                    for (int i=0;i<dataModel.getData().size();i++) {
                        points_text.add(dataModel.getData().get(i).getPoints() + "");
                        Log.e("points_",dataModel.getData().get(i).getPoints()+"");
                        img_sources.add(i,R.drawable.redemmt_icon);
                    }
                    ImageAdapter adapter = new ImageAdapter(RedeemPoints.this, img_sources, points_text);
                    grid=(GridView)findViewById(R.id.grid_view);
                    grid.setAdapter(adapter);
                }
            }
            @Override
            public void failed(boolean fromConnection) {

            }
        });
    }
}
