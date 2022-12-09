package com.example.clase05;

import java.io.Serializable;

public class BecaTransporte implements Serializable {
    //Atributos
    private int folio;
    private String institucion;
    private String apellidos;
    private String nombre;
    private float monto;
    //metodos

    public BecaTransporte(int folio, String institucion, String apellidos, String nombre, float monto) {
        this.folio = folio;
        this.institucion = institucion;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.monto = monto;
    }
    public BecaTransporte() {
        this.folio = -1;
        this.institucion = "none";
        this.apellidos = "none";
        this.nombre = "none";
        this.monto = 0.0f;
    }
    //getters y setters

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }


}
