package com.example.dpdm1_clase01;

public class Alumno {
    //Atributoss
    private String nombre;
    private int edad;
    //Metodos
    //constructor
    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad  = edad;
    }
    public Alumno() {
        this.nombre = "none";
        this.edad  = 0;
    }

    //Setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
