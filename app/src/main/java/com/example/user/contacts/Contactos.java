package com.example.user.contacts;

public class Contactos {
    private String NombreContacto;
    private String TelefonoContacto;
    private String CorreContacto;
    private int fotoContacto;
    private boolean favoritos;

    //constructor
    public Contactos(String nombre, String telefono, String correo, int foto, boolean favoritos) {
        this.NombreContacto = nombre;
        this.TelefonoContacto = telefono;
        this.CorreContacto = correo;
        this.fotoContacto = foto;
        this.favoritos = favoritos;
    }

    public Contactos() {
    }

    //setters
    public void setNombreContacto(String nombre) {
        NombreContacto = nombre;
    }

    public void setTelefonoContacto(String telefono) {
        TelefonoContacto = telefono;
    }

    public void setCorreContacto(String correo) {
        CorreContacto = correo;
    }

    public void setFotoContacto(int foto) {
        fotoContacto = foto;
    }

    public void setFavoritos(boolean favoritos) {
        this.favoritos = favoritos;
    }

    //getters
    public String getNombreContacto() {
        return NombreContacto;
    }

    public String getTelefonoContacto() {
        return TelefonoContacto;
    }

    public String getCorreContacto() {
        return CorreContacto;
    }

    public int getFotoContacto() {
        return fotoContacto;
    }

    public boolean isFavoritos() {
        return favoritos;
    }
}