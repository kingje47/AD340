package com.jk.hw7;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import static com.jk.hw7.MainActivity.CAMERA_DATA;

// Class designed after Google Maps video from Canvas https://canvas.northseattle.edu/courses/1741126/pages/video-google-maps?module_item_id=35493386

public class CameraLocationActivity extends AppCompatActivity
    implements OnMapReadyCallback {

    private final static String TAG = "CAMERA_LOCATION_ACTIVITY";
    private FusedLocationProviderClient mLocationClient;
    private boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_location);
        mLocationClient = LocationServices.getFusedLocationProviderClient(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @SuppressLint("MissingPermission")
    private void getLocation(){
        if (mLocationPermissionGranted) {
            Task location = mLocationClient.getLastLocation();
            location.addOnCompleteListener(new OnCompleteListener<Location>() {
                @SuppressLint("LongLogTag")
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location actualLocation = task.getResult();
                    if (actualLocation != null) {
                        String latLong = String.format("Lat: %f, Long: %f", actualLocation.getLatitude(), actualLocation.getLongitude());

                        mMap.setMyLocationEnabled(true);
                        mMap.getUiSettings().setMyLocationButtonEnabled(true);

                        LatLng here = new LatLng(actualLocation.getLatitude(), actualLocation.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(here).title("Current location"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(here, 10));

                        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                    } else {
                        Log.e(TAG, "Location is null...");
                    }
                }
            });
        }
    }

    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getLocationPermission();
        getLocation();

        Bundle bundle = this.getIntent().getExtras();
        String[] cameraFromIntent = bundle.getStringArray(CAMERA_DATA);
        Double cameraLat = Double.parseDouble(cameraFromIntent[0]);
        Double cameraLon = Double.parseDouble(cameraFromIntent[1]);
        LatLng cameraLocation = new LatLng(cameraLat, cameraLon);
        Marker marker = mMap.addMarker(new MarkerOptions().position(cameraLocation).title(cameraFromIntent[2]));
    }
}
