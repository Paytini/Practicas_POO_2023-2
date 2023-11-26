/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosopaletras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *esta clase se cxtiende de la super clase "SopaDeLetras" se encarga de generar una sopa de letras numéricas utilizando un algoritmo para esconder elementos 
 * numéricos en diferentes direcciones dentro de la cuadrícula y guarda las coordenadas y 
 * direcciones de estos elementos en un archivo de texto.
 * @author jolin
 */
public class SopaDeLetraNumerica extends SopaDeLetras {
    
    public SopaDeLetraNumerica(int filas, int columnas){
        super(filas,columnas);
        
    }

    @Override
    protected void generarSopa(String direccion, ArrayList<String> elementos) {
        Random random = new Random();
        HashMap<String, String> coordenadas = new HashMap<>(); // HashMap para almacenar coordenadas

        for (String elemento : elementos) {
            boolean elementoColocado = false;

            while (!elementoColocado) {
                int esconder = random.nextInt(3); // 0: vertical, 1: horizontal, 2: diagonal

                // Lógica para esconder el elemento según la dirección seleccionada
                int filaInicial, columnaInicial;

                if (esconder == 0) { // Verticalmente de arriba hacia abajo
                    filaInicial = random.nextInt(15 - elemento.length() + 1) + 1; // Ajuste +1
                    columnaInicial = random.nextInt(15) + 1; // Ajuste +1

                    for (int i = 0; i < elemento.length(); i++) {
                        matrizSopa[filaInicial + i - 1][columnaInicial - 1] = Integer.parseInt(elemento.substring(i, i + 1));
                    }
                    coordenadas.put(elemento, "Fila: " + filaInicial + ", Columna: " + columnaInicial + ", Dirección: Vertical");
                } else if (esconder == 1) { // Horizontalmente de derecha a izquierda
                    filaInicial = random.nextInt(15) + 1; // Ajuste +1
                    columnaInicial = random.nextInt(15 - elemento.length() + 1) + 1; // Ajuste +1

                    for (int i = 0; i < elemento.length(); i++) {
                        matrizSopa[filaInicial - 1][columnaInicial + i - 1] = Integer.parseInt(elemento.substring(elemento.length() - 1 - i, elemento.length() - i));
                    }
                    coordenadas.put(elemento, "Fila: " + filaInicial + ", Columna: " + columnaInicial + ", Dirección: Horizontal");
                } else { // Diagonalmente de abajo hacia arriba
                    filaInicial = random.nextInt(15 - elemento.length() + 1) + 1; // Ajuste +1
                    columnaInicial = random.nextInt(15 - elemento.length() + 1) + 1; // Ajuste +1

                    for (int i = 0; i < elemento.length(); i++) {
                        matrizSopa[filaInicial + i - 1][columnaInicial + i - 1] = Integer.parseInt(elemento.substring(elemento.length() - 1 - i, elemento.length() - i));
                    }
                    coordenadas.put(elemento, "Fila: " + filaInicial + ", Columna: " + columnaInicial + ", Dirección: Diagonal");
                }

                elementoColocado = true; // Marcar el elemento como colocado
            }
        }

        GestorDeArchivos g = new GestorDeArchivos();
        g.guardarCoordenadas("C:\\ArchivosJava\\coordenadas.txt", coordenadas);

        // Llenar los espacios restantes con números aleatorios
        for (int i = 0; i < matrizSopa.length; i++) {
            for (int j = 0; j < matrizSopa[i].length; j++) {
                if (matrizSopa[i][j] == null) { // Si el espacio está vacío
                    matrizSopa[i][j] = random.nextInt(10); // Llenar con un número aleatorio del 0 al 9
                }
            }
        }
    }


    
}
