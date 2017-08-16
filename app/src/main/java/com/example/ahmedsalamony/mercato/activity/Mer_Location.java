package com.example.ahmedsalamony.mercato.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.ahmedsalamony.mercato.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mer_Location extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mer__location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng branch1 = new LatLng(30.7921024, 31.0024722);
        LatLng branch2 = new LatLng(30.7936133, 30.9961207);
        mMap.addMarker(new MarkerOptions().position(branch1).title("Mercato cafe"));
        mMap.addMarker(new MarkerOptions().position(branch2).title("Mercato cafe"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(branch1));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(branch1, 15.0f));
    }
}
