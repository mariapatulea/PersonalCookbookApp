package com.example.personalcookbookapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class RestaurantsActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private MapView mapView1, mapView2, mapView3, mapView4, mapView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        mapView1 = findViewById(R.id.map_view_1);
        mapView1.onCreate(savedInstanceState);
        mapView1.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setMinZoomPreference(15);
                googleMap.setMaxZoomPreference(19);

                LatLng restaurant1 = new LatLng(44.4797836, 26.0834218);
                Objects.requireNonNull(googleMap.addMarker(new MarkerOptions()
                                .position(restaurant1)
                                .title("Stadio Park")))
                        .setSnippet("Herastrau Park, Șoseaua Nordului 7-9, Bucharest 014101");

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant1));
            }
        });

        mapView2 = findViewById(R.id.map_view_2);
        mapView2.onCreate(savedInstanceState);
        mapView2.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setMinZoomPreference(15);
                googleMap.setMaxZoomPreference(19);

                LatLng restaurant2 = new LatLng(44.4268106, 26.1108889);
                Objects.requireNonNull(googleMap.addMarker(new MarkerOptions()
                                .position(restaurant2)
                                .title("Amethyst Sky Bar")))
                        .setSnippet("Bulevardul Unirii 47C, București 030825");

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant2));
            }
        });

        mapView3 = findViewById(R.id.map_view_3);
        mapView3.onCreate(savedInstanceState);
        mapView3.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setMinZoomPreference(15);
                googleMap.setMaxZoomPreference(19);

                LatLng restaurant3 = new LatLng(44.4785653, 26.1002402);
                Objects.requireNonNull(googleMap.addMarker(new MarkerOptions()
                                .position(restaurant3)
                                .title("Trickshot Promenada")))
                                .setSnippet("București, Mall Promenada, Calea Floreasca 246B, București 014476");

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant3));
            }
        });

        mapView4 = findViewById(R.id.map_view_4);
        mapView4.onCreate(savedInstanceState);
        mapView4.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setMinZoomPreference(15);
                googleMap.setMaxZoomPreference(19);

                LatLng restaurant4 = new LatLng(44.4773868, 26.0688011);
                Objects.requireNonNull(googleMap.addMarker(new MarkerOptions()
                                .position(restaurant4)
                                .title("18 Lounge")))
                        .setSnippet("Piața Presei Libere 3-5 City Gate - South Tower, 18th Floor, București 013702");

                googleMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant4));
            }
        });

        mapView5 = findViewById(R.id.map_view_5);
        mapView5.onCreate(savedInstanceState);
        mapView5.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // Customize the map
                googleMap.setMinZoomPreference(15);
                googleMap.setMaxZoomPreference(19);

                // Add a marker for the restaurant
                LatLng restaurant5 = new LatLng(44.4503724, 26.0939862);
                Objects.requireNonNull(googleMap.addMarker(new MarkerOptions()
                                .position(restaurant5)
                                .title("Trattoria Mezzaluna")))
                        .setSnippet("Strada Crăciun 3, București 101010");

                // Move the camera to the restaurant
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant5));
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.open_nav,
                R.string.close_nav
        );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        Button navButton = findViewById(R.id.nav_button);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        startActivity(new Intent(RestaurantsActivity.this, HomeActivity.class));
                        break;
                    case R.id.nav_account:
                        startActivity(new Intent(RestaurantsActivity.this, AccountActivity.class));
                        break;
                    case R.id.nav_restaurants:
                        startActivity(new Intent(RestaurantsActivity.this, RestaurantsActivity.class));
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        setTitle("Top 5 Bucharest Restaurants");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

     @Override
    public void onResume() {
        super.onResume();
        mapView1.onResume();
        mapView2.onResume();
        mapView3.onResume();
        mapView4.onResume();
        mapView5.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView1.onPause();
        mapView2.onPause();
        mapView3.onPause();
        mapView4.onPause();
        mapView5.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView1.onDestroy();
        mapView2.onDestroy();
        mapView3.onDestroy();
        mapView4.onDestroy();
        mapView5.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView1.onLowMemory();
        mapView2.onLowMemory();
        mapView3.onLowMemory();
        mapView4.onLowMemory();
        mapView5.onLowMemory();
    }
}