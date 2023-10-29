/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica5mastermind;

import java.util.ArrayList;
import java.util.HashSet;
import java.awt.Color;

/**
 * Clase que modela graficamente el tablero del juego
 *
 * @version 24/10/22
 * @author Jolin
 */
public class Tablero {

    HashSet<String> allColors = new HashSet<>();
    private Rectangulo tablero;
    private Rectangulo rec;
    private int contador = 0;
    private int contPines = 0;
    private int turnos;
    private ArrayList<Circle> fichas = new ArrayList();
    private ArrayList<Circle> agujeroBandera = new ArrayList();

    private ArrayList<Circle> respuesta = new ArrayList(6);

    public Tablero(int turnos) {
        this.turnos = turnos;
        asignarTablero(turnos);
    }

    public int getTurnos() {
        return this.turnos;
    }

    public void setFichas(String color, int posicion) {
        fichas.get(posicion).changeColor(color);
    }

    public void setBandera(String color, int posicion) {
        agujeroBandera.get(posicion).changeColor(color);
    }

    public ArrayList<Circle> getFichas() {
        return fichas;
    }

    /**
     * Este metodo nos permite poder dibujar el tablero a partir de una variable
     * x y otra y, las cuales funcionan de guia para dibujar tanto el tablero
     * como las posiciones donde iran colocados las pistas y las fichas
     */
    public void dibujarTablero() {
        int x = 405, y = 495;
        tablero.changeColor("lightGray");
        tablero.cambiarPosicion(375, 0);
        tablero.changeSize(280, 550);
        tablero.makeVisible();
        rec.changeColor("Gray");
        rec.cambiarPosicion(400, 525);
        rec.changeSize(180, 25);
        rec.makeVisible();
        for (int i = 0; i < fichas.size(); i++) {
            if (i % 6 == 0 && i != 0) {
                x = 405;

                y -= 33;
            }
            fichas.get(i).changeColor("Gray");
            fichas.get(i).cambiarPosicion(x, y);
            fichas.get(i).changeSize(25);
            fichas.get(i).makeVisible();
            x += 30;
        }
        x = 590;
        y = 510;
        for (int i = 0; i < agujeroBandera.size(); i++) {
            if (i % 3 == 0 && i != 0) {
                x = 590;
                y -= 15;
            }
            if (i % 6 == 0 && i != 0) {
                y -= 3;
            }
            agujeroBandera.get(i).changeColor("Gray");
            agujeroBandera.get(i).cambiarPosicion(x, y);
            agujeroBandera.get(i).changeSize(10);
            agujeroBandera.get(i).makeVisible();
            x += 15;
        }
    }

    /**
     * Este metodo nos regresa un vector tipo String el cual se genera a partir
     * de un String cadena que se separara por espacios para poder formar el
     * vector
     */
    public String[] colores(String colores) {
        String[] color = colores.split(" ");
        //for(int i=0; i<color.length; i++){
        // System.out.println(color[i]);
        //}
        return color;
    }

    /**
     * Este metodo nos permite colocar las fichas en el tablero a partir de los
     * agujeros previamente colocados en la funcion "dibujarTablero" los cuales
     * a partir de llamar a la funcion "colores" obtendremos el vector de
     * colores que ingrese el jugador para poder determinar cuales colores
     * ingreso el y poder realizar las modificaciones
     *
     * tambien nos indica si uno de los colores es invalido. Tambien llama a la
     * funcion "colocarBanderas" con la finalidad de que si la sentencia de
     * colores ingresada es correcta entonces coloca las banderas respectivas.
     */
    public void colocarFichas(String colores, Bandera banderas) {
        boolean ban = true;
        String[] colors = colores(colores);
        for (int i = 0; i < 6; i++) {
            if (colors[i].equalsIgnoreCase("Az")) {
                fichas.get(contador + i).changeColor("blue");
            } else if (colors[i].equalsIgnoreCase("Am")) {
                fichas.get(contador + i).changeColor("yellow");
            } else if (colors[i].equalsIgnoreCase("Ro")) {
                fichas.get(contador + i).changeColor("red");
            } else if (colors[i].equalsIgnoreCase("Ve")) {
                fichas.get(contador + i).changeColor("green");
            } else if (colors[i].equalsIgnoreCase("Bl")) {
                fichas.get(contador + i).changeColor("white");
            } else if (colors[i].equalsIgnoreCase("Ne")) {
                fichas.get(contador + i).changeColor("black");
            } else if (colors[i].equalsIgnoreCase("Mo")) {
                fichas.get(contador + i).changeColor("purple");
            } else if (colors[i].equalsIgnoreCase("Na")) {
                fichas.get(contador + i).changeColor("orange");
            } else {
                System.out.println(colors[i] + " Es un color no valido");
                ban = false;
            }

        }
        if (ban) {
            colocarBanderas(banderas);
            contador += 6;
        }

    }
//Metodo que muestra las fichas de respuesta correcta del juego

    public void dibujarRespuesta(String resStr) {
        String[] color = resStr.split(" ");
        int x = 405;
        int y = 525;
        for (int i = 0; i < 6; i++) {
            respuesta.add(new Circle());
            if (color[i].equalsIgnoreCase("Az")) {
                respuesta.get(i).changeColor("blue");
            } else if (color[i].equalsIgnoreCase("Am")) {
                respuesta.get(i).changeColor("yellow");
            } else if (color[i].equalsIgnoreCase("Ro")) {
                respuesta.get(i).changeColor("red");
            } else if (color[i].equalsIgnoreCase("Ve")) {
                respuesta.get(i).changeColor("green");
            } else if (color[i].equalsIgnoreCase("Bl")) {
                respuesta.get(i).changeColor("white");
            } else if (color[i].equalsIgnoreCase("Ne")) {
                respuesta.get(i).changeColor("black");
            } else if (color[i].equalsIgnoreCase("Na")) {
                respuesta.get(i).changeColor("orange");
            } else if (color[i].equalsIgnoreCase("Mo")) {
                respuesta.get(i).changeColor("purple");
            }

            respuesta.get(i).cambiarPosicion(x + (30 * i), y);
            respuesta.get(i).changeSize(25);
            respuesta.get(i).makeVisible();
        }
    }

    /**
     * Esta funcion nos permite modificar 4 elementos del arreglo de
     * agujeroBandera con la finalidad de a partir de la sentencia ingresada
     * poder modificar el color de dicho arreglo y poder obtener las pistas
     */
    public void colocarBanderas(Bandera banderas) {

        for (int i = 0; i < 6; i++) {
            agujeroBandera.get(contador + i).changeColor(banderas.getPin(i));
        }
    }

    /**
     * Esta funcion crea los objetos correspondientes y llena los arreglos
     * dependiendo de los intentos que solicite el usuario.
     */
    public int asignarTablero(int intentos) {
        tablero = new Rectangulo();
        rec = new Rectangulo();
        for (int i = 0; i < intentos * 6; i++) {
            fichas.add(new Circle());
            agujeroBandera.add(new Circle());
        }
        return intentos * 6;
    }
}
