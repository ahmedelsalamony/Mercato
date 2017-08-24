package com.apps.square.mercato.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.adapter.RecyclerAdapter;
import com.apps.square.mercato.fragments.fragment_menu;
import com.apps.square.mercato.models.MyWalletModel;
import com.apps.square.mercato.models.PointsModel;
import com.apps.square.mercato.tools.APIManager;
import com.apps.square.mercato.ui.LoadingManager;
import com.apps.square.mercato.viewholder.WalletHolder;
import com.apps.square.mercato.viewholder.pointsHolder;

import java.util.List;

public class MyWallet extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LoadingManager loadingManager;

    public static View head;
    public static TextView texthead;
    private Class currentFragmentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        loadingManager = new LoadingManager(this, findViewById(R.id.progressBar));

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
                    .replace(R.id.activity_my_wallet, fragment)
                    .commit();
        }
    }

    public void getPoints() {
        APIManager.getMyWallet(this,"1", new APIManager.ResponseListener<MyWalletModel>() {
            @Override
            public void done(MyWalletModel dataModel) {
                if (dataModel.getApi_status()==1) {
                    loadingManager.hideLoadingProgress();
                    adddata(dataModel.getCards());

                }
            }
            @Override
            public void failed(boolean fromConnection) {

            }
        });
    }

    public void adddata(final List<MyWalletModel.RedeemCards> data) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(data, R.layout.row_wallet, WalletHolder.class,
                new RecyclerAdapter.AdapterInterface<MyWalletModel.RedeemCards, WalletHolder>() {
                    @Override
                    public void fillData(final MyWalletModel.RedeemCards dataModel, final WalletHolder viewHolder)
                    {
                        viewHolder.getTxt_redeem_points().setText(dataModel.getValue()+"");
                        viewHolder.getTxt_expired().setText(dataModel.getExpire_date());

                    }});
        recyclerView.setAdapter(recyclerAdapter);
    }
}
