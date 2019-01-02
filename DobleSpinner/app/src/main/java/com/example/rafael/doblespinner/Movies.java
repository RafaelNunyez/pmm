package com.example.rafael.doblespinner;

import java.io.Serializable;

public class Movies implements Serializable {
    private int id;
    private String title;
    private int year;
    private String description;

    public Movies(int id, String title, int year, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
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

    public String getDescription() {
        return description;
    }
}
