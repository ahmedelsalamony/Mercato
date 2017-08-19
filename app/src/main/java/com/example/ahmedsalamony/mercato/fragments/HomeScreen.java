package com.example.ahmedsalamony.mercato.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.activity.Mer_Location;
import com.example.ahmedsalamony.mercato.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Salamony on 8/16/2017.
 */

public class HomeScreen extends Fragment {

    private static Fragment fragment;
    View rootview;
    List<Integer> data;
    List<String> txtData;

    public static Fragment newInstance() {

        fragment = new MercatoLocation();
        return fragment;
    }

    public HomeScreen() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_home_screen, container, false);
        GridView gridView = (GridView) rootview.findViewById(R.id.grid_view);
        data=new ArrayList<Integer>();
        data.add(0,R.drawable.joinus);
        data.add(1,R.drawable.menu);
        data.add(2,R.drawable.aboutus);
        data.add(3,R.drawable.products);
        data.add(4,R.drawable.location);
        data.add(5,R.drawable.review);
        txtData=new ArrayList<String>();
        txtData.add(0,"Join Us");
        txtData.add(1,"Menu");
        txtData.add(2,"About Us");
        txtData.add(3,"Our Projects");
        txtData.add(4,"Our Location");
        txtData.add(5,"Reviews");
        gridView.setAdapter(new ImageAdapter(getActivity(),data,txtData));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==4){
                Intent i=new Intent(getActivity(), Mer_Location.class);
                getActivity().startActivity(i);
            }
            }
        });
        return rootview;
    }
}
