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
 * Esta clase facilita la lectura y almacenamiento de elementos desde un archivo de texto, así como la 
 * adición de nuevos elementos a la lista interna
 * @author jolin
 */
public class Elementos {
    private ArrayList<String> elementos;
    
    public Elementos(){
        this.elementos = new ArrayList<String>();
    }
    
    // Método para leer los elementos desde el archivo de texto
    public ArrayList<String> leerElementos(String direccion) {

        try (BufferedReader br = new BufferedReader(new FileReader(direccion))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                elementos.add(linea.trim().substring(0, Math.min(linea.trim().length(), 10)));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return elementos;
    }
    
    public void agregarElemento(String elem){
        this.elementos.add(elem);
    }
    
}
