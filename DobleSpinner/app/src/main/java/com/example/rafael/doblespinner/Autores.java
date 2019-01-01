package com.example.rafael.doblespinner;

import java.io.Serializable;
import java.util.ArrayList;

public class Autores implements Serializable {
    private int id;
    private String nombre;
    private String lenguaje;
    private String nacimiento;
    private int imagen;
    private ArrayList<Obras> obras;

    public Autores (int id, String nombre, String lenguaje, String nacimiento, int imagen, ArrayList<Obras> obras) {
        this.id = id;
        this.nombre = nombre;
        this.lenguaje = lenguaje;
        this.nacimiento = nacimiento;
        this.imagen = imagen;
        this.obras = obras;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public int getImagen() {
        return imagen;
    }

    public ArrayList<Obras> getObras() {
        return obras;
    }
}
