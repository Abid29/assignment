package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FruitActivity extends AppCompatActivity {

    ImageView imageView;
    ConstraintLayout firstLayout;
    TextView title, headline, learn, description, innerText ,textButton;
    ArrayList<Fruit>fruitArrayList;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        imageView = findViewById(R.id.imageView);
        firstLayout = findViewById(R.id.v1);
        title = findViewById(R.id.name);
        headline = findViewById(R.id.headline);
        learn = findViewById(R.id.learning);
        description = findViewById(R.id.desc);
        innerText = findViewById(R.id.innerText);
        textButton = findViewById(R.id.textButton);

        Intent intent = getIntent();
        int position = intent.getIntExtra("FRUIT_ID" , 0);

        fruitArrayList = new Util().getAllFruits();

        Fruit fruit = fruitArrayList.get(position);

        Glide.with(this)
                .asBitmap()
                .load(this.getResources().getIdentifier(fruit.image, "drawable", this.getPackageName()))
                .into(imageView);


        int[] colors = {Color.parseColor(fruit.getGradientColors().get(0)) , Color.parseColor(fruit.getGradientColors().get(1))};

        GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM , colors);

        firstLayout.setBackground(gd);

        title.setText(fruit.title);
        title.setTextColor(Color.parseColor(fruit.getGradientColors().get(1)));
        headline.setText(fruit.headline);
        learn.setText("LEARN MORE ABOUT " + fruit.title.toUpperCase());
        learn.setTextColor(Color.parseColor(fruit.getGradientColors().get(0)));
        description.setText(fruit.description);
        innerText.setBackgroundColor(Color.parseColor("#B2BEB5"));

        textButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}