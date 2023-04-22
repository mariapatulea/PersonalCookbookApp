package com.example.personalcookbookapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalcookbookapp.Recipes.PastacarbonaraFragment;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Objects;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<String> title_id, short_description_id, difficulty_id;

    public CustomAdapter(Context context, ArrayList<String> title_id, ArrayList<String> short_description_id, ArrayList<String> difficulty_id) {
        this.context = context;
        this.title_id = title_id;
        this.short_description_id = short_description_id;
        this.difficulty_id = difficulty_id;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recipe_entry, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.title_id.setText(String.valueOf(title_id.get(position)));
        holder.short_description_id.setText(String.valueOf(short_description_id.get(position)));
        holder.difficulty_id.setText(String.valueOf(difficulty_id.get(position)));

        final String title = title_id.get(position);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecipeDetailsActivity.class);
                intent.putExtra("title", title);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title_id.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView title_id, short_description_id, difficulty_id;
        CardView mCardView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            title_id = itemView.findViewById(R.id.title_text);
            short_description_id = itemView.findViewById(R.id.short_description_text);
            difficulty_id = itemView.findViewById(R.id.difficulty_text);
            mCardView = itemView.findViewById(R.id.card_view);
        }
    }
}
