package com.example.personalcookbookapp.Recipes;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalcookbookapp.DBHelper;
import com.example.personalcookbookapp.R;


public class BalsamiccapreseFragment extends Fragment {

    private String mTitle;

    public BalsamiccapreseFragment() {
        // Required empty public constructor
    }

    public static BalsamiccapreseFragment newInstance(String title) {
        Log.d("in abalsamic caprese fragment", title);
        BalsamiccapreseFragment fragment = new BalsamiccapreseFragment();
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
        View view = inflater.inflate(R.layout.fragment_balsamiccaprese, container, false);
        TextView titleTextView = view.findViewById(R.id.title_text);
        titleTextView.setText(mTitle);

        Button saveRecipeButton = view.findViewById(R.id.save_recipe);
        Button removeRecipeButton = view.findViewById(R.id.remove_recipe);

        DBHelper dbHelper = new DBHelper(getContext());

        saveRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                String username = preferences.getString("username", "");

                boolean res = dbHelper.saveRecipe(username, "Balsamic Caprese");

                if (res) {
                    Toast.makeText(getContext(), "Recipe saved", Toast.LENGTH_SHORT).show();
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

                boolean res = dbHelper.removeSavedRecipe(username, "Balsamic Caprese");

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
}