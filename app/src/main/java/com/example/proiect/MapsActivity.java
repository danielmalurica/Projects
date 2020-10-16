package com.example.proiect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Camera;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btnGetDirection;
    MarkerOptions loc1, loc2, loc3;
    Polyline currentPolyline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        loc1=new MarkerOptions().position(new LatLng(44.384184,26.1326306)).title("Home");
        loc2=new MarkerOptions().position(new LatLng(44.4441195,26.0710053)).title("Biblioteca Nationala");
        loc3=new MarkerOptions().position(new LatLng(44.4440486,26.09727)).title("Biblioteca Metropolitana");


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
        LatLng home = new LatLng(44.384184,26.1326306);
        LatLng nationala = new LatLng(44.4441195,26.0710053);
        LatLng metropolitana = new LatLng(44.4440486,26.09727);
        mMap.addMarker(new MarkerOptions().position(home).title("Marker in Bucharest, home!"));
        mMap.addMarker(new MarkerOptions().position(nationala).title("Biblioteca Nationala a Romaniei!"));
        mMap.addMarker(new MarkerOptions().position(metropolitana).title("Biblioteca Nationala a Romaniei!"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(home, 10f));

    }


}
