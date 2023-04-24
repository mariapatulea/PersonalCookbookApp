package com.example.personalcookbookapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.personalcookbookapp.R;
import com.example.personalcookbookapp.Fragments.BalsamiccapreseFragment;
import com.example.personalcookbookapp.Fragments.BeefbroccoliFragment;
import com.example.personalcookbookapp.Fragments.BlueberrysconesFragment;
import com.example.personalcookbookapp.Fragments.CheesecakeFragment;
import com.example.personalcookbookapp.Fragments.ChocoloatesmoothieFragment;
import com.example.personalcookbookapp.Fragments.GrilledoctopusFragment;
import com.example.personalcookbookapp.Fragments.HabaneroskewersFragment;
import com.example.personalcookbookapp.Fragments.LemonshrimpFragment;
import com.example.personalcookbookapp.Fragments.MushroompizzaFragment;
import com.example.personalcookbookapp.Fragments.PastacarbonaraFragment;
import com.example.personalcookbookapp.Fragments.PeachburratasaladFragment;
import com.example.personalcookbookapp.Fragments.PolentaFragment;
import com.example.personalcookbookapp.Fragments.QuinoachiliFragment;
import com.example.personalcookbookapp.Fragments.RaspberrycheesecakebarsFragment;
import com.example.personalcookbookapp.Fragments.SpinachchickenFragment;

import java.util.Objects;

public class RecipeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        createNotificationChannel();

        String title = getIntent().getStringExtra("title");

        Log.d("in recipe details activity, title is", title);

        if (Objects.equals(title, "Pasta Carbonara")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, PastacarbonaraFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Balsamic Caprese")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, BalsamiccapreseFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Beef Broccoli")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, BeefbroccoliFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Blueberry Scones")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, BlueberrysconesFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Cheesecake")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, CheesecakeFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Chocolate Smoothie")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, ChocoloatesmoothieFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Grilled Octopus")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, GrilledoctopusFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Habanero Skewers")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, HabaneroskewersFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Lemon Shrimp")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, LemonshrimpFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Mushroom Pizza")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, MushroompizzaFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Peach & Burrata Salad")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, PeachburratasaladFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Polenta")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, PolentaFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Quinoa Chili")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, QuinoachiliFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Raspberry Cheesecake Bars")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, RaspberrycheesecakebarsFragment.newInstance(title));
            fragmentTransaction.commit();
        } else if (Objects.equals(title, "Spinach Chicken")) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, SpinachchickenFragment.newInstance(title));
            fragmentTransaction.commit();
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel Name";
            String description = "My Channel Description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("my_channel_id", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}