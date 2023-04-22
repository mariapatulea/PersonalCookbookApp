package com.example.personalcookbookapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class AccountActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    SharedPreferences sharedPreferences;
    TextView textView;
    RecyclerView recyclerView;
    CustomAdapterSavedRecipes customAdapterSavedRecipes;
    ArrayList<String> title;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sharedPreferences.getString("username", "");

        textView = findViewById(R.id.text_view);
        textView.setText("Welcome, " + username + "!");

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
                        startActivity(new Intent(AccountActivity.this, HomeActivity.class));
                        break;
                    case R.id.nav_account:
                        startActivity(new Intent(AccountActivity.this, AccountActivity.class));
                        break;
                    case R.id.nav_restaurants:
                        startActivity(new Intent(AccountActivity.this, RestaurantsActivity.class));
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        setTitle("My Account");

        DB = new DBHelper(this);
        title = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview2);
        customAdapterSavedRecipes = new CustomAdapterSavedRecipes(this, title);
        recyclerView.setAdapter(customAdapterSavedRecipes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaySavedRecipes(username);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void displaySavedRecipes(String username) {
        Cursor cursor = DB.getSavedRecipes(username);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "There are no saved recipes to display.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                title.add(cursor.getString(1));
            }
        }
        cursor.close();
    }
}