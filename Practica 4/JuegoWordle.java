/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/**
 *
 * @author jolin
 */
public class JuegoWordle {
    ITablero tablero;
    ITeclado teclado;
    private String palabra;

    public JuegoWordle(ITablero tablero, ITeclado teclado) {
        this.tablero = tablero;
        this.teclado = teclado;
    }
    
    public void jugar() {
        ArrayList<String> palabrasIngresadas = new ArrayList<>();
        tablero = new TableroHolografica();
        boolean juego = false;
        String rutaArchivo = "C:/Users/jolin/OneDrive/Documents/NetBeansProjects/Wordle/src/main/java/com/mycompany/wordle/palabras.txt";
        String[] palabrasDelArchivo = leerArchivo(rutaArchivo);
        Random random = new Random();
        String palabraSeleccionada = palabrasDelArchivo[random.nextInt(palabrasDelArchivo.length)];
        
        int ronda = 0;
        while(!juego && ronda < 6){
            palabra = this.teclado.getIntento();
            boolean palabraEncontrada = false;
            for (String palabraArchivo : palabrasDelArchivo) {
                if (palabraArchivo.equals(palabra)) {
                    palabraEncontrada = true;
                    break;
                }
            }
            if(palabraEncontrada){
                palabrasIngresadas.add(palabra);
                tablero.mostrarPalabrasEscritas(palabrasIngresadas);
                int respuesta = tablero.determinarRespuesta(palabra, palabraSeleccionada);
                if(respuesta != 4){
                    System.out.println("NO ES CORRECTO, VUELVE A INGRESAR UNA PALABRA\n");
                }
                else{
                    System.out.println("LA PALABRA ES CORRECTA, ADIVINASTES!\n\n TERMINA EL JUEGO");
                    juego = true;
                }
                ronda++;
            }else{
                System.out.println("ESA PALABRA NO SE ENCUENTRA EN LA LISTA, VUELVE A INTENTARLO");
            }
        }
       
        
    }
    
    public static String[] leerArchivo(String rutaArchivo) {
        ArrayList<String> palabras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en palabras usando espacios como delimitador
                String[] palabrasEnLinea = linea.split("\\s+");
                palabras.addAll(Arrays.asList(palabrasEnLinea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return palabras.toArray(new String[0]);
    }

}
