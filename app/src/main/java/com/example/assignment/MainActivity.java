package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vp;
    TabLayout tabLayout;
    ArrayList<Fruit> fruitArrayList;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        fruitArrayList = new Util().getAllFruits();

        VPAdapter adapter = new VPAdapter(fruitArrayList, this);
        vp.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, vp, (tab, position) -> {
            tab.setIcon(R.drawable.baseline_circle_24);
        }).attach();

    }
}