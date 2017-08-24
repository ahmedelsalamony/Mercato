package com.apps.square.mercato.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.square.mercato.R;
import com.apps.square.mercato.fragments.fragment_menu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mer_Location extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng branch1,branch2;

    public static View head;
    public static TextView texthead;
    private Class currentFragmentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mer__location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        head=findViewById(R.id.menu);
        texthead=(TextView)findViewById(R.id.headtext);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(new fragment_menu());
            }
        });

        TextView nady_navigation=(TextView)findViewById(R.id.txt_navidation_nady);
        TextView radwan_navigation=(TextView)findViewById(R.id.txt_navidation_radwan);


        nady_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMap.moveCamera(CameraUpdateFactory.newLatLng(branch1));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(branch1, 17.0f));
            }
        });

        radwan_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMap.moveCamera(CameraUpdateFactory.newLatLng(branch2));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(branch2, 17.0f));

            }
        });

        ImageView menu=(ImageView)findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Mer_Location.this,HomeActivity.class);
                i.putExtra("where",1);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }
    private void openFragment(Fragment fragment) {
        if (currentFragmentClass != fragment.getClass()) {
            currentFragmentClass = fragment.getClass();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.mer_location_activity, fragment)
                    .commit();
        }
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
        branch1 = new LatLng(30.7921024, 31.0024722);
        branch2 = new LatLng(30.7936133, 30.9961207);
        mMap.addMarker(new MarkerOptions().position(branch1).title("Mercato cafe").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_location_marker)));
        mMap.addMarker(new MarkerOptions().position(branch2).title("Mercato cafe").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_location_marker)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(branch1));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(branch1, 15.0f));
    }
}
