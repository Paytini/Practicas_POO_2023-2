/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosopaletras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  Esta seria nuestra superclase, esta clase contendra metodos que nos servira para nuestros clases hijos 
 * @author jolin
 */
public abstract class SopaDeLetras {
    
    protected Object[][] matrizSopa;

    public Object[][] getMatrizSopa() {
        return matrizSopa;
    }
    
     // Constructor para una sopa de letras de tamaño específico
    public SopaDeLetras(int filas, int columnas) {
        matrizSopa = new Object[filas][columnas];
    }
    
    public SopaDeLetras(){
        matrizSopa = new Object[15][15];
    }
    
    protected abstract void generarSopa(String direccion, ArrayList<String> elementos);  // Este metodo lo que hara es crear nuestra sopa dependiendo del tipo de sopa
    
    protected void imprimirSopa(String direccion){ // Imprime la sopa, esto es importante para cuando queramos mostrarlo en el interfaz
        for (int i = 0; i < matrizSopa.length; i++) {
            for (int j = 0; j < matrizSopa[i].length; j++) {
                System.out.print(matrizSopa[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
