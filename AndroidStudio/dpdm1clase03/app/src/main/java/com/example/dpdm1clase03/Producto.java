package com.example.dpdm1clase03;

public class Producto {
    //Atributos
    public int  codigo;
    public String descripcion;
    public String marca;
    public String modelo;
    public int cantidad;
    public float costoUnitario;
    //Metodos
    //constructor por default

    public Producto() {
        this.codigo = 0;
        this.descripcion = "descripcion";
        this.marca = "marca";
        this.modelo = "modelo";
        this.cantidad = 0;
        this.costoUnitario = 0.0f;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
