package com.example.googlemap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    ArrayList<LatLng>arrayList = new ArrayList<LatLng>();
    LatLng Maharashtra = new LatLng(19.389137, 76.031094);
    LatLng Aurangabad = new LatLng(19.856844, 75.361846);
    LatLng Latur = new LatLng(18.399193, 76.574761);
    LatLng Solapur = new LatLng(17.643136, 75.929257);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapAPI);

        mapFragment.getMapAsync(this);
        arrayList.add(Maharashtra);
        arrayList.add(Aurangabad);
        arrayList.add(Latur);
        arrayList.add(Solapur);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

            mapAPI = googleMap;
            for(int i =0;i<arrayList.size();i++)
            {
                mapAPI.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Marker"));
                mapAPI.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
                mapAPI.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
            }
    }
}
