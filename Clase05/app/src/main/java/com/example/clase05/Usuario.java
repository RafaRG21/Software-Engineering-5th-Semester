package com.example.clase05;

public class Usuario {
    //Atributos
    private String correo;
    private String contrasena;
    private Boolean registrado;
    //Metodos
    //Constructor personalizado
    public Usuario(String correo, String contrasena, Boolean registrado) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.registrado = registrado;
    }
    //constructor por default
    public Usuario() {
        this.correo = "none";
        this.contrasena = "none";
        this.registrado = false;
    }
    //setters y getters

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getRegistrado() {
        return registrado;
    }

    public void setRegistrado(Boolean registrado) {
        this.registrado = registrado;
    }


}
