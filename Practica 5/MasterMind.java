/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica5mastermind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.*;


/**
 * Clase Principal que ejecuta una partida del juego de Mastermind
 * Esta clase nos permite poder ingresar la cantidad de intentos que desee el usuario, asi como llevar el control del juego
 *
 * @version 
 * @author jolin
 */
public class MasterMind {
// 

    public static JLabel label;

    public static void main(String[] args) {
    
        Secuencia combinacionAdivinar;
        Secuencia combinacionJugador = new Secuencia();
        HashSet<String> allColors = new HashSet<>();
        Bandera bandera = new Bandera();
        Tablero tablero;
        Scanner scn = new Scanner(System.in);
        String cadena;
        String out;
        String opc2;
        String colores = "";
   
        
        JOptionPane.showMessageDialog(null,"BIENVENIDO AL JUEGO DEMASTER MIND!","Juego Master Mind",JOptionPane.INFORMATION_MESSAGE);
        do {
            int limiteDeIntentos = 0;
            boolean ban = false, victoria = false;
            //CICLO PARA LOS COLORES REPETIDOS O DISTINTOS
            //GENERACION DE LA RESPUESTA
          
            colores = generarSecuencia(false);
            colores = colores.toUpperCase();
            //System.out.println(colores);
            combinacionAdivinar = new Secuencia(colores.split(" "));
            
            //INICIO DEL JUEGO
            System.out.println("_________________Bienvenido a MASTERMIND_________________");  
            limiteDeIntentos = 15;
            tablero = new Tablero(limiteDeIntentos);
            tablero.dibujarTablero();
            limiteDeIntentos = 0;
            //CICLO PRINCIPAL
            do {
                do {
                    System.out.println("RESPUESTA CORRECTA: \t[ " + colores + "] ");
                    System.out.println("TURNO # " + (limiteDeIntentos + 1));
                    System.out.println("Menú de colores disponibles:");
                    System.out.println("Az - Azul\nAm - Amarillo\nNe - Negro\nBl - Blanco\nVe - Verde\nRo - Rojo\nNa - Naranja\nMo - Morado");
                    System.out.println("\n\nIngresa la combinacion en formato (Am Az Bl Ne Mo Na): ");
                    cadena = scn.nextLine();
                    ban = comprobar(cadena);
                    if (ban) {
                        if (allColors.contains(cadena)) {
                            System.out.println("No se pueden agregar sentencias iguales!!!");
                            ban = false;
                        } else {
                            allColors.add(cadena);
                            cadena = cadena.toUpperCase();
                            combinacionJugador.setFichas(cadena.split(" "));
                            bandera = verificarCombinacion(combinacionAdivinar, combinacionJugador);
                            tablero.colocarFichas(cadena, bandera);
                            for (int i = 0; i < 6; i++) {
                                System.out.println(bandera.getPin(i));
                            }
                            
                            if (colores.equals(cadena)) {
                                System.out.println("\n\n\tCOMBINACION CORRECTA. FELICIDADES JUGADOR!!!");

                                System.out.println("RESPUESTA CORRECTA:\t[ " + colores + "] ");

                                tablero.dibujarRespuesta(colores);
                                victoria = true;
                            }
                           
                        }
                    }
                } while (ban == false);

                limiteDeIntentos++;
                // COINDICIONAR SI EL JUGADOR SE QUEDO SIN TURNOS 
                if (limiteDeIntentos == tablero.getTurnos() && victoria == false) {
                    victoria = true;
                    System.out.println("Limite de intentos alcanzados\n\t\tPERDISTE");
                    System.out.println("RESPUESTA CORRECTA: \t[ " + colores + "] ");
                    tablero.dibujarRespuesta(colores);
                }
            } while (victoria == false);
            System.out.println("Volver a jugar? [SI/NO]");
            out = scn.next().toUpperCase().trim();
            if (out.equals("NO")) {
                System.out.println("_________________FIN DEL JUEGO_________________");
                System.exit(0);
            } else {
                System.out.println("Reiniciando...");
            }
            //REICIAR JUEGO PARA VOLVER A JUGAR
            combinacionJugador = new Secuencia();
            allColors.clear();
        } while (!out.equalsIgnoreCase("NO"));
    }

    /**
     * Esta funcion se encarga de realizar la verificacion de la combinacion que
     * ingresa el jugador con la combinacion que se crea por defecto en el juego
     * (combinacionAdivinar), esto lo hace verificando los colores por su
     * posicion combinacionAdivinar verifica la ficha de la posicion i con la
     * ficha de la posicion j de conbinacionJugador si son iguales entonces
     * regresa true y si la posicion donde se encontraron son iguales entonces
     * la ficha esta correctamente colocada si no pues quiere decir que si se
     * encuentra pero en otra posicion. Esta funcion regresa un objeto Bandera
     * que son las pistas de ese turno
     */
    public static Bandera verificarCombinacion(Secuencia combinacionAdivinar, Secuencia combinacionJugador) {
        Bandera banderas = new Bandera();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (combinacionAdivinar.verificarFicha(combinacionJugador.getFicha(j), i) == true) {
                    if (i == j) {
                        banderas.setPin(i, "black");
                        //System.out.println("aqui negro: " + "i: " + i + "j: " + j);
                        j = 5;
                    } else {
                        banderas.setPin(i, "white");
                        //System.out.println("aqui blanco: " + "i: " + i + "j: " + j);
                        j = 5;
                    }
                }
                else{
                    banderas.setPin(i,"Gray");
                }
            }
        }
        return banderas;
    }

    /**
     * Esta funcion se encarga de generar una secuencia de colores
     * aleatoriamente que luego se convertira en la combinacion que tiene que
     * adivinar el jugador.
     */
    public static String generarSecuencia(boolean duplicados) {
        String color = "";
        Random alea = new Random();
        final String[] colores = {"Az", "Am", "Ro", "Ve", "Bl", "Ne","Na","Mo"}; //COLORES VALIDOS
        ArrayList<String> str = new ArrayList<>(6); //COLECCION DE COLORES GENERADOS
        str.clear();
        while (str.size() < 6) { //LLENAR COLECCION
            String aux = (colores[alea.nextInt(8)]);
            if (duplicados) { //PERMITIR DUPLICADOS
                str.add(aux);
            } else if (!str.contains(aux)) { //NO PERMITIR REPETIDOS
                str.add(aux);
            }
        }
        //CONVERTIR EL ARRAY A STRING
        for (int i = 0; i < 6; i++) {
            color = color.concat(str.get(i) + " ");
        }

        color = color.trim();
        return color;
    }

    /**
     * Esta funcion se encarga de reaizar la comprobacion de colores que ingreso
     * el jugador, si la combinacion de colores se encuentra entre los colores
     * disponibles entonces regresa true que indica que todo es correcto, de
     * caso contrario regresa false y te indica el error.
     */
    public static boolean comprobar(String colores) {
        boolean ban = true;
        String[] colors = colores.split(" ");
        //System.out.println(colors.length);
        if (colors.length == 6) {
            for (int i = 0; i < 6; i++) {
                if (colors[i].equalsIgnoreCase("Az")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Am")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Ro")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Ve")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Bl")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Ne")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Na")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Mo")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase(" ")) {
                    System.out.println("No se permiten colores vacios!");
                    ban =  false;
                    i = 5;
                } else {
                    System.out.println(colors[i] + " Es un color no valido");
                    ban = false;
                    i = 5;
                }
            }
        } else {
            System.out.println("Solo se permite ingresar 6 colores!!!");
            ban = false;
        }
        return ban;
    }
}
