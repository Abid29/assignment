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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getGradientColors() {
        return gradientColors;
    }

    public void setGradientColors(ArrayList<String> gradientColors) {
        this.gradientColors = gradientColors;
    }

    public ArrayList<String> getNutritions() {
        return nutritions;
    }

    public void setNutritions(ArrayList<String> nutritions) {
        this.nutritions = nutritions;
    }
}
