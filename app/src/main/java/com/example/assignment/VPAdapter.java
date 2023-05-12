package com.example.assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.ViewHolder> {

    ArrayList<Fruit> fruitArrayList = new ArrayList<>();

    public VPAdapter(ArrayList<Fruit> fruitArrayList) {
        this.fruitArrayList = fruitArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpageritem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruitArrayList.get(position);

        //holder.imageView.setImageResource(getResources().getIdentifier(fruit.image, "drawable", getPackageName()));
        holder.heading.setText(fruit.title);
        holder.desc.setText(fruit.headline);
    }

    @Override
    public int getItemCount() {
        return fruitArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView heading, desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            heading = itemView.findViewById(R.id.heading);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
