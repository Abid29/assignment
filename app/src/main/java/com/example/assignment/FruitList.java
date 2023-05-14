package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FruitList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Fruit>fruitArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);

        recyclerView = findViewById(R.id.recView);

        fruitArrayList = new Util().getAllFruits();
        recViewAdapter adapter = new recViewAdapter(fruitArrayList,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}