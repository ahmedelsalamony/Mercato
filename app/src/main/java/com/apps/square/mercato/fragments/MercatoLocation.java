package com.apps.square.mercato.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.square.mercato.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

/**
 * Created by Ahmed Salamony on 8/14/2017.
 */

public class MercatoLocation extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;

    private static Fragment fragment;

    public static Fragment newInstance() {

        fragment = new MercatoLocation();
        return fragment;
    }

    public MercatoLocation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mercato_location, container, false);


        return rootView;
    }

}
