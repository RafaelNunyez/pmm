package com.example.rafael.doblespinner;

import java.io.Serializable;

public class Obras implements Serializable {
    private int id;
    private String titulo;
    private String editorial;
    private String isbn;
    private String description;

    public Obras (int id, String titulo, String editorial, String isbn, String description) {
        this.id = id;
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }
}
