package com.example.parcial1ruizjose;

public class Cotizacion {
    private String marca;
    private String modelo;
    private int costoBase;
    private int plazo;
    private float mensualidad;
    private float enganche;
    private float comision;
    //Constructor

    public Cotizacion(){
        this.marca = "none";
        this.modelo = "none";
        this.costoBase = 0;
        this.plazo = 36;
        this.mensualidad = 0;
        this.enganche = 0;
        this.comision = 0;

    }
    //getters y setter
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

    public int getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(int costoBase) {
        this.costoBase = costoBase;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public float getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(float mensualidad) {
        this.mensualidad = mensualidad;
    }

    public float getEnganche() {
        return enganche;
    }

    public void setEnganche(float enganche) {
        this.enganche = enganche;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }
}
