package com.apps.square.mercato.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.square.mercato.R;
import com.apps.square.mercato.activity.HomeActivity;
import com.apps.square.mercato.activity.MyWallet;
import com.apps.square.mercato.activity.RedeemPoints;
import com.apps.square.mercato.tools.DataManager;

import java.util.List;

/**
 * Created by Ahmed Salamony on 8/16/2017.
 */

public class fragment_menu extends Fragment {

    private static Fragment fragment;
    View rootview;
    List<String> data;
    List<String> txtData;
    TextView txtprofile,txtwallet,txtredeem,txtlogout,txtoffers;

    public static Fragment newInstance() {

        fragment = new fragment_menu();
        return fragment;
    }

    public fragment_menu() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_menu_screen, container, false);
        ImageView backbtn=(ImageView)rootview.findViewById(R.id.backbtn);

        txtprofile=(TextView) rootview.findViewById(R.id.txtprofile);
        txtwallet=(TextView) rootview.findViewById(R.id.txtwallet);
        txtredeem=(TextView) rootview.findViewById(R.id.txtredeem);
        txtoffers=(TextView) rootview.findViewById(R.id.txtoffers);
        txtlogout=(TextView) rootview.findViewById(R.id.txtlogout);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), HomeActivity.class);
                getActivity().startActivity(i);
            }
        });

        txtprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtprofile.setBackgroundColor(Color.parseColor("#5a1d18"));//dark
                txtwallet.setBackgroundColor(Color.parseColor("#b11e24"));
                txtredeem.setBackgroundColor(Color.parseColor("#b11e24"));
                txtoffers.setBackgroundColor(Color.parseColor("#b11e24"));
                txtlogout.setBackgroundColor(Color.parseColor("#b11e24"));
            }
        });

        txtwallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtwallet.setBackgroundColor(Color.parseColor("#5a1d18"));//dark
                txtprofile.setBackgroundColor(Color.parseColor("#b11e24"));
                txtredeem.setBackgroundColor(Color.parseColor("#b11e24"));
                txtoffers.setBackgroundColor(Color.parseColor("#b11e24"));
                txtlogout.setBackgroundColor(Color.parseColor("#b11e24"));

                Intent i=new Intent(getActivity(), MyWallet.class);
                startActivity(i);
            }
        });

        txtredeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtredeem.setBackgroundColor(Color.parseColor("#5a1d18"));//dark
                txtwallet.setBackgroundColor(Color.parseColor("#b11e24"));
                txtprofile.setBackgroundColor(Color.parseColor("#b11e24"));
                txtoffers.setBackgroundColor(Color.parseColor("#b11e24"));
                txtlogout.setBackgroundColor(Color.parseColor("#b11e24"));

                Intent i=new Intent(getActivity(), RedeemPoints.class);
                startActivity(i);
            }
        });

        txtoffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtoffers.setBackgroundColor(Color.parseColor("#5a1d18"));//dark
                txtredeem.setBackgroundColor(Color.parseColor("#b11e24"));
                txtwallet.setBackgroundColor(Color.parseColor("#b11e24"));
                txtprofile.setBackgroundColor(Color.parseColor("#b11e24"));
                txtlogout.setBackgroundColor(Color.parseColor("#b11e24"));
            }
        });

        txtlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtlogout.setBackgroundColor(Color.parseColor("#5a1d18"));//dark
                txtoffers.setBackgroundColor(Color.parseColor("#b11e24"));
                txtredeem.setBackgroundColor(Color.parseColor("#b11e24"));
                txtwallet.setBackgroundColor(Color.parseColor("#b11e24"));
                txtprofile.setBackgroundColor(Color.parseColor("#b11e24"));

                DataManager.setStringSetting(getActivity(),"LoginKey","");

                Toast.makeText(getActivity(), DataManager.getStringSetting(getActivity(),"LoginKey","") + "", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getActivity(),HomeActivity.class);
                startActivity(i);
            }
        });
        return rootview;
    }
}
