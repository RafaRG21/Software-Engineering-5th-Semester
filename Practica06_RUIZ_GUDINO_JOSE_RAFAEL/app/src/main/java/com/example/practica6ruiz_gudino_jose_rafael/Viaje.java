package com.example.practica6ruiz_gudino_jose_rafael;

public class Viaje {
    private int codigo;
    private int numAsientos;
    private float costo;
    private String clase;
    private String destino;
    //Constructor
    public Viaje() {
        this.codigo = 0;
        this.numAsientos = 0;
        this.costo = 0;
        this.clase = "Economy";
        this.destino = "Mexico";
    }
    //Getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
