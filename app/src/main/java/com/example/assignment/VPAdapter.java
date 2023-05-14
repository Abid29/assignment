package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.ViewHolder> {

    ArrayList<Fruit> fruitArrayList = new ArrayList<>();
    Context context;

    public VPAdapter(ArrayList<Fruit> fruitArrayList, Context context) {
        this.fruitArrayList = fruitArrayList;
        this.context = context;
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

        holder.heading.setText(fruit.title);
        holder.desc.setText(fruit.headline);
        Log.d("ABIDUL", "onBindViewHolder: " + fruit.image);
        Glide.with(context)
                .asBitmap()
                .load(getImage(fruit.image))
                .into(holder.imageView);

        int[] colors = {Color.parseColor(fruit.getGradientColors().get(0)), Color.parseColor(fruit.getGradientColors().get(1))};
        //create a new gradient color
        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gd.setCornerRadius(0f);

        //holder.cardView.setCardBackgroundColor(gd.getColor());
        holder.relativeLayout.setBackground(gd);

        holder.button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FruitList.class);
                context.startActivity(intent);
            }
        });

    }

//    private byte[] getImage(String imageName) {
//        String imagePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + imageName;
//
//        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        byte[] imageData = stream.toByteArray();
//
//        return imageData;
//    }


    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView heading, desc;
        RelativeLayout relativeLayout;
        TextView button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            heading = itemView.findViewById(R.id.heading);
            desc = itemView.findViewById(R.id.desc);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            button = itemView.findViewById(R.id.stBtn);
        }
    }

    public int getImage(String imageName) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResourceId;
    }
}
