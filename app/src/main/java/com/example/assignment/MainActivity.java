package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vp;
    ArrayList<Fruit> fruitArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.pager);
        fruitArrayList = new Util().getAllFruits();

        VPAdapter adapter = new VPAdapter(fruitArrayList, this);
        vp.setAdapter(adapter);
    }
}