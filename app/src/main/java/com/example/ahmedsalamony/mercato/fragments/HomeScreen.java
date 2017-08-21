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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.ahmedsalamony.mercato.R;
import com.example.ahmedsalamony.mercato.activity.Menu;
import com.example.ahmedsalamony.mercato.activity.Mer_Location;
import com.example.ahmedsalamony.mercato.activity.Products_Categories;
import com.example.ahmedsalamony.mercato.activity.Reviews;
import com.example.ahmedsalamony.mercato.activity.TotalReviews;
import com.example.ahmedsalamony.mercato.adapter.ImageAdapter;
import com.google.android.gms.vision.text.Line;

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
    RelativeLayout joinus,menu,aboutus,products,ourlocation,reviews;


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
        joinus=(RelativeLayout)rootview.findViewById(R.id.join_container);
        menu=(RelativeLayout)rootview.findViewById(R.id.menu_container);
        aboutus=(RelativeLayout)rootview.findViewById(R.id.about_container);
        products=(RelativeLayout)rootview.findViewById(R.id.products_container);
        ourlocation=(RelativeLayout)rootview.findViewById(R.id.location_container);
        reviews=(RelativeLayout)rootview.findViewById(R.id.reviews_container);


        joinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), Products_Categories.class);
                getActivity().startActivity(i);
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), Products_Categories.class);
                getActivity().startActivity(i);
            }
        });

        ourlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), Mer_Location.class);
                getActivity().startActivity(i);
            }
        });

        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), TotalReviews.class);
                getActivity().startActivity(i);
            }
        });

   /*     GridView gridView = (GridView) rootview.findViewById(R.id.grid_view);
        data=new ArrayList<Integer>();
        data.add(0,R.drawable.join_us);
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
            }else if(position==5){
                    Intent i=new Intent(getActivity(), TotalReviews.class);
                    getActivity().startActivity(i);
                }else if(position==3){
                    Intent i=new Intent(getActivity(), Products_Categories.class);
                    getActivity().startActivity(i);
                }else if (position==2){
                    Intent i=new Intent(getActivity(), Products_Categories.class);
                    getActivity().startActivity(i);
                }else if (position==1){
                    Intent i=new Intent(getActivity(), Menu.class);
                    getActivity().startActivity(i);
                }else if (position==0){
                    Intent i=new Intent(getActivity(), Menu.class);
                    getActivity().startActivity(i);
                }
            }
        });*/
        return rootview;
    }
}
