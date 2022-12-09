package com.example.practica03_ruiz_gudino_jose_rafael;

public class Motocicleta {
    //Atributos
    private String marca;
    private String modelo;
    private int numSerie;
    private int velocidadMaxima;
    private int capacidadTanque;

    //Constructores
    public Motocicleta(){
        this.marca = "none";
        this.modelo = "none";
        this.numSerie = 0;
        this.velocidadMaxima = 0;
        this.capacidadTanque = 0;
    }

    public Motocicleta(String marca, String modelo, int numSerie, int velocidadMaxima, int capacidadTanque) {
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.velocidadMaxima = velocidadMaxima;
        this.capacidadTanque = capacidadTanque;
    }

    //getters y setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getCapacidadTanque() {
        return capacidadTanque;
    }

    public void setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }
}
