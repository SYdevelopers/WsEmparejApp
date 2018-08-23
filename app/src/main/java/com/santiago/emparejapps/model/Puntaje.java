package com.santiago.emparejapps.model;

public class Puntaje {
    private String nombre;
    private int puntos;
    private String nivel;
    private int tiempo;

    public static String nomJ1="",nomJ2="";
    public Puntaje() {
    }

    public Puntaje(String nombre, int puntos, String nivel, int tiempo) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.nivel = nivel;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
