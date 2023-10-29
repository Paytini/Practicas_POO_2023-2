/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica5mastermind;

/**
 * Clase Clase que modela las secuencias de colores de las fichas del juego
 *
 * @version 24/10/22
 * @author Jolin
 */
public class Secuencia {

    private String[] fichas; //Crea las fichas
    private int posicion; //Auxiliar para guardar posicion

    public Secuencia() {
        fichas = new String[6];
    }

    public Secuencia(String[] fichas) {
        this.fichas = fichas;
    }
//Regresa una ficha

    public String getFicha(int pos) {
        return fichas[pos];
    }

    public String[] getAllFicha() {
        return fichas;
    }
//Cambia el color de una ficha

    public void setFichas(String[] fichas) {
        this.fichas = fichas;
    }
//Regresa la posicion

    public int getPosicion() {
        return posicion;
    }

//Cambiar la Posicion
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
//Verifica si la ficha se encuentra y regresa un boolean de confirmacion

    public boolean verificarFicha(String ficha, int pos) {
        boolean pista = false;
        if (fichas[pos].equals(ficha)) {
            pista = true;
        }
        return pista;
    }
}

