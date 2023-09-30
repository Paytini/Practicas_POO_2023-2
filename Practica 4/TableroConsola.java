/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordle;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jolin
 */
public class TableroConsola implements ITablero {
    @Override
    public void despliegaIntento(String palabra) {
        System.out.println(palabra);
    }
    
    @Override
    public boolean revisarPalabra(String palabra){
        String patron = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(palabra);
        
        boolean correcto = matcher.matches();
        return correcto;
    }
    
    @Override
    public int determinarRespuesta(String palabra, String respuesta){
        int acum = 0;
        if (palabra.length() != respuesta.length()) {
        System.out.println("Las longitudes de las palabras no coinciden, todas las letras son GRIS.");
        return 0;
        }

        char[] respuestaArray = respuesta.toCharArray();
        char[] palabraArray = palabra.toCharArray();

        for (int i = 0; i < respuestaArray.length; i++) {
            if (respuestaArray[i] == palabraArray[i]) {
                acum++;
                System.out.println("Letra " + palabraArray[i] + ": VERDE");
            } else if (respuesta.contains(String.valueOf(palabraArray[i]))) {
                System.out.println("Letra " + palabraArray[i] + ": AMARILLO");
            } else {
                System.out.println("Letra " + palabraArray[i] + ": GRIS");
            }
        }  
        
        return acum;
    }
    
    @Override
    public void mostrarPalabrasEscritas(ArrayList<String> palabras){
        int i = 1;
        System.out.println("\nTABLERO: \n");
        for(String pal: palabras){
            System.out.println(i + ". " + pal);
        }
    }
    
    
}
