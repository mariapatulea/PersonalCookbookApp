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
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> title, short_description, difficulty;
    DBHelper DB;
    CustomAdapter customAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchView = findViewById(R.id.search_bar);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchRecipes(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchRecipes(newText);
                return false;
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
                        startActivity(new Intent(HomeActivity.this, HomeActivity.class));
                        break;
                    case R.id.nav_account:
                        startActivity(new Intent(HomeActivity.this, AccountActivity.class));
                        break;
                    case R.id.nav_restaurants:
                        startActivity(new Intent(HomeActivity.this, RestaurantsActivity.class));
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        setTitle("Home Page");

        DB = new DBHelper(this);
        title = new ArrayList<>();
        short_description = new ArrayList<>();
        difficulty = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        customAdapter = new CustomAdapter(this, title, short_description, difficulty);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void displaydata() {
        DB.addRecipes();
        Cursor cursor = DB.getRecipesData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "There are no recipes to display.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                title.add(cursor.getString(0));
                short_description.add(cursor.getString(1));
                difficulty.add(cursor.getString(2));
            }
        }
        cursor.close();
    }

    private void searchRecipes(String query) {
        title.clear();
        short_description.clear();
        difficulty.clear();

        Cursor cursor = DB.searchRecipes(query);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No recipes found.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                title.add(cursor.getString(0));
                short_description.add(cursor.getString(1));
                difficulty.add(cursor.getString(2));
            }
        }
        cursor.close();
        customAdapter.notifyDataSetChanged();
    }
}