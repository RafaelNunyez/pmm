package com.example.rafael.doblespinner;

import java.io.Serializable;
import java.util.ArrayList;

public class Studios implements Serializable {
    private int id;
    private String name;
    private String country;
    private int founded;
    private int image;
    private ArrayList<Movies> movies;

    public Studios(int id, String name, String country, int founded, int image, ArrayList<Movies> movies) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.founded = founded;
        this.image = image;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getFounded() {
        return founded;
    }

    public int getImage() {
        return image;
    }

    public ArrayList<Movies> getMovies() {
        return movies;
    }
}
