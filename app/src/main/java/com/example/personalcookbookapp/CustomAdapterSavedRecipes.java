package com.example.personalcookbookapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class CustomAdapterSavedRecipes extends RecyclerView.Adapter<CustomAdapterSavedRecipes.CustomViewHolder> {
    Context context;
    ArrayList<String> title_id;

    public CustomAdapterSavedRecipes(Context context, ArrayList<String> title_id) {
        this.context = context;
        this.title_id = title_id;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.saved_recipe_entry, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterSavedRecipes.CustomViewHolder holder, int position) {
        holder.title_id.setText(String.valueOf(title_id.get(position)));

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
        TextView title_id;
        CardView mCardView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            title_id = itemView.findViewById(R.id.title_text);
            mCardView = itemView.findViewById(R.id.card_view);
        }
    }
}
