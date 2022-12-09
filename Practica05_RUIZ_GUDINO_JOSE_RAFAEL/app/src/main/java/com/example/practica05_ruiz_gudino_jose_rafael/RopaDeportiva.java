package com.example.practica05_ruiz_gudino_jose_rafael;

public class RopaDeportiva {
    //Atributos
    private int codigo;
    private String marca;
    private String modelo;
    private String talla;
    private String colores;
    private float costo;

    //Constructor
    public RopaDeportiva(){
        this.codigo = 0;
        this.marca = "none";
        this.modelo = "none";
        this.talla = "Mediana";
        this.colores = "";
        this.costo = 0;
    }
    public RopaDeportiva(int codigo, String marca, String modelo, String talla, String colores, float costo) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.colores = colores;
        this.costo = costo;
    }
    //Getters y Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

}//class
