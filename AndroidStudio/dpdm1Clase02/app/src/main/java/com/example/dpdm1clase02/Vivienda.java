package com.example.dpdm1clase02;

import java.io.Serializable;

public class Vivienda implements Serializable {
    //Atributos
    private int folio;
    private String cliente;
    private int tipoVivienda;
    private String detalle;
    private int telefono;

    //Metodos
    public Vivienda(){
        this.folio = 0;
        this.cliente = "none";
        this.tipoVivienda = 1;
        this.detalle = "none";
        this.telefono = 0;
    }
    public Vivienda(int folio, String cliente, int tipoVivienda, String detalle, int telefono) {
        this.folio = folio;
        this.cliente = cliente;
        this.tipoVivienda = tipoVivienda;
        this.detalle = detalle;
        this.telefono = telefono;
    }

    //Getters y Setters
    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(int tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}//class
