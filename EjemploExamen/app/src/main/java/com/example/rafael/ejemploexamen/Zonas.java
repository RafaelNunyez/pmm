package com.example.rafael.ejemploexamen;

import java.io.Serializable;

public class Zonas implements Serializable {
    private int id;
    private String zona;
    private String pais;
    private String precio;

    public Zonas (int id, String zona, String pais, String precio) {
        this.id = id;
        this.zona = zona;
        this.pais = pais;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getZona() {
        return zona;
    }

    public String getPais() {
        return pais;
    }

    public String getPrecio() {
        return precio;
    }
}
