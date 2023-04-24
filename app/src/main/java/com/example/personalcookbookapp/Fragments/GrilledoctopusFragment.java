package com.example.personalcookbookapp.Fragments;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalcookbookapp.Activities.AccountActivity;
import com.example.personalcookbookapp.DataBase.DBHelper;
import com.example.personalcookbookapp.R;

public class GrilledoctopusFragment extends Fragment {

    private static final int MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS = 123;
    private String mTitle;

    public GrilledoctopusFragment() {
        // Required empty public constructor
    }

    public static GrilledoctopusFragment newInstance(String title) {
        GrilledoctopusFragment fragment = new GrilledoctopusFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString("title");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grilledoctopus, container, false);
        TextView titleTextView = view.findViewById(R.id.title_text);
        titleTextView.setText(mTitle);

        Button saveRecipeButton = view.findViewById(R.id.save_recipe);
        Button removeRecipeButton = view.findViewById(R.id.remove_recipe);

        DBHelper dbHelper = new DBHelper(getContext());

        saveRecipeButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                String username = preferences.getString("username", "");

                boolean res = dbHelper.saveRecipe(username, "Grilled Octopus");

                if (res) {
                    Toast.makeText(getContext(), "Recipe saved", Toast.LENGTH_SHORT).show();

                    if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.POST_NOTIFICATIONS}, MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS);
                    } else {
                        showNotification();
                    }

                } else {
                    Toast.makeText(getContext(), "Recipe could NOT be saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

        removeRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                String username = preferences.getString("username", "");

                boolean res = dbHelper.removeSavedRecipe(username, "Grilled Octopus");

                if (res) {
                    Toast.makeText(getContext(), "Recipe deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Recipe could NOT be deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "my_channel_id")
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Recipe Saved")
                .setContentText("Click here to view all your saved recipes!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(createPendingIntent());

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());

        if (ActivityCompat.checkSelfPermission(this.requireContext(), Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(1, builder.build());
    }

    private PendingIntent createPendingIntent() {
        Intent intent = new Intent(requireContext(), AccountActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return PendingIntent.getActivity(requireContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showNotification();
            } else {
                Toast.makeText(requireContext(), "Permission denied. Cannot show notification.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}