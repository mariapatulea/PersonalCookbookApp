package com.example.personalcookbookapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalcookbookapp.Activities.RecipeDetailsActivity;
import com.example.personalcookbookapp.R;

import java.util.ArrayList;

public class CustomAdapterAllRecipes extends RecyclerView.Adapter<CustomAdapterAllRecipes.CustomViewHolder> {
    private final Context context;
    private final ArrayList<String> title_id, short_description_id, difficulty_id;

    public CustomAdapterAllRecipes(Context context, ArrayList<String> title_id, ArrayList<String> short_description_id, ArrayList<String> difficulty_id) {
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

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
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
