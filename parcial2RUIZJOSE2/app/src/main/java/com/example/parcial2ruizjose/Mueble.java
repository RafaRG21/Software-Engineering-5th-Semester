package com.example.parcial2ruizjose;

public class Mueble {
    private int codigo;
    private String marca;
    private String modelo;
    private String talla;
    private String colores;

    public Mueble(int codigo, String marca, String modelo, String talla, String colores) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.talla = talla;
        this.colores = colores;
    }
    public Mueble() {
        this.codigo = -1;
        this.marca = "marca";
        this.modelo = "asas";
        this.talla = "mediano";
        this.colores = "negro";
    }
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
}
