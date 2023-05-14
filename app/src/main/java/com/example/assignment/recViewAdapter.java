package com.example.assignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Fruit fruit = fruits.get(position);

        holder.heading.setText(fruit.title);
        holder.description.setText(fruit.headline);
        Glide.with(context)
                .asBitmap()
                .load(context.getResources().getIdentifier(fruit.image, "drawable", context.getPackageName()))
                .into(holder.imageView);


        int[] colors = {Color.parseColor(fruit.getGradientColors().get(0)), Color.parseColor(fruit.getGradientColors().get(1))};
        //create a new gradient color
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gd.setCornerRadius(0f);

        holder.imageView.setBackground(gd);

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , FruitActivity.class);
                intent.putExtra("FRUIT_ID" , position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView heading, description;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            heading = itemView.findViewById(R.id.heading);
            description = itemView.findViewById((R.id.desc));
            cardView = itemView.findViewById(R.id.crdvw);
        }
    }
}
