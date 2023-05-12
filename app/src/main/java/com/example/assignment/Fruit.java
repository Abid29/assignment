package com.example.assignment;

import java.util.ArrayList;

public class Fruit {
    int id;
    String title, headline, image, description;
    ArrayList<String> gradientColors,nutritions;

    public Fruit(int id, String title, String headline, String image, String description, ArrayList<String> gradientColors, ArrayList<String> nutritions) {
        this.id = id;
        this.title = title;
        this.headline = headline;
        this.image = image;
        this.description = description;
        this.gradientColors = gradientColors;
        this.nutritions = nutritions;
    }
}
