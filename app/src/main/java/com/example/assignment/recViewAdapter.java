package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recViewAdapter extends RecyclerView.Adapter<recViewAdapter.ViewHolder> {
    ArrayList<Fruit>fruits = new ArrayList<>();
    Context context;

    public recViewAdapter(ArrayList<Fruit> fruits, Context context) {
        this.fruits = fruits;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruit_list_rec_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);

        holder.heading.setText(fruit.title);
        holder.description.setText(fruit.headline);
        Glide.with(context)
                .asBitmap()
                .load(context.getResources().getIdentifier(fruit.image, "drawable", context.getPackageName()))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView heading, description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            heading = itemView.findViewById(R.id.heading);
            description = itemView.findViewById((R.id.desc));
        }
    }
}
