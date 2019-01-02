package com.example.rafael.doblespinner;

import java.io.Serializable;

public class Movies implements Serializable {
    private int id;
    private String title;
    private int year;
    private int image;
    private String description;

    public Movies(int id, String title, int year, int image, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
