package com.apps.square.mercato.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class RedeemPoints extends AppCompatActivity {
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_points);
        List<Integer> img_sources=new ArrayList<>();
        img_sources.add(0,R.drawable.redemmt_icon);
        img_sources.add(1,R.drawable.redemmt_icon);
        img_sources.add(2,R.drawable.redemmt_icon);
        img_sources.add(3,R.drawable.redemmt_icon);
        img_sources.add(4,R.drawable.redemmt_icon);
        img_sources.add(5,R.drawable.redemmt_icon);

        List<String> points_text=new ArrayList<>();
        points_text.add(0," Redeem 50 ");
        points_text.add(1," Redeem 100");
        points_text.add(2," Redeem 200");
        points_text.add(3," Redeem 300");
        points_text.add(4," Redeem 400");
        points_text.add(5," Redeem 500");

        ImageAdapter adapter = new ImageAdapter(RedeemPoints.this, img_sources, points_text);
        grid=(GridView)findViewById(R.id.grid_view);
        grid.setAdapter(adapter);
    }
}
