package com.example.ngo;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.ngo.databinding.ActivityMapFinalBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map_Final extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapFinalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapFinalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng vidarb = new LatLng(21.149, 79.0820);
        LatLng nagpur = new LatLng(21.149, 79.0820);
        LatLng chandrapur = new LatLng(20.0967, 79.5045);
        LatLng wani = new LatLng(19.97, 78.95);
        LatLng bhandara = new LatLng(21.1230, 79.7939);
        LatLng gondia = new LatLng(21.4552, 80.1962);
        LatLng wardha = new LatLng(20.7453, 78.6022);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vidarb, 7));
        mMap.addMarker(new MarkerOptions().position(nagpur).title("Marker in Nagpur"));
        mMap.addMarker(new MarkerOptions().position(chandrapur).title("Marker in Chandrapur"));
        mMap.addMarker(new MarkerOptions().position(wani).title("Marker in Wani"));
        mMap.addMarker(new MarkerOptions().position(bhandara).title("Marker in Bhandara"));
        mMap.addMarker(new MarkerOptions().position(gondia).title("Marker in gondia"));
        mMap.addMarker(new MarkerOptions().position(wardha).title("Marker in wardha"));

    }
}