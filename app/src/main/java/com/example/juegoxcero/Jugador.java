// Jugador.java
package com.example.juegoxcero;

public class Jugador {
    private String nombre;
    private int victoriasX;
    private int victoriasO;
    private String simboloAsignado;    // “X”, “0” o ""

    public Jugador(String nombre, int victoriasX, int victoriasO, String simboloAsignado) {
        this.nombre = nombre;
        this.victoriasX = victoriasX;
        this.victoriasO = victoriasO;
        this.simboloAsignado = simboloAsignado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictoriasX() {
        return victoriasX;
    }

    public void setVictoriasX(int v) {
        this.victoriasX = v;
    }

    public int getVictoriasO() {
        return victoriasO;
    }

    public void setVictoriasO(int v) {
        this.victoriasO = v;
    }

    public String getSimboloAsignado() {
        return simboloAsignado;
    }

    public void setSimboloAsignado(String s) {
        this.simboloAsignado = s;
    }
}
