package com.example.practica07ruizgudinojoserafael;

import java.io.Serializable;

public class Pedido implements Serializable {
    //Atributos
    private String nombre;
    private String domicilio;
    private String producto;
    private String talla;
    private long telefono;

    //Constructor
    public Pedido(String nombre, String domicilio, String producto, String talla, long telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.producto = producto;
        this.talla = talla;
        this.telefono = telefono;
    }
    public Pedido() {
        this.nombre = "none";
        this.domicilio = "none";
        this.producto = "none";
        this.talla = "Mediana";
        this.telefono = -1;
    }
//Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }




}
