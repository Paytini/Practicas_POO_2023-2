/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectosopaletras;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * En esta clase su principal funciona es trabajar con los metodos
 * de trabajar con los archivos de texto como leer, escribir o crear un
 * archivo de texto.
 * @author jolin
 */
public class GestorDeArchivos {
    
    public void guardarSopaEnArchivo(String nombreArchivo, Object[][] matrizSopa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\ArchivosJava\\" + nombreArchivo))) {
            for (Object[] fila : matrizSopa) {
                StringBuilder filaString = new StringBuilder();
                for (Object elemento : fila) {
                    filaString.append(elemento.toString()).append(" ");
                }
                writer.write(filaString.toString().trim());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String leerSopaEnArchivo(String nombre){
       StringBuilder contenido = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\ArchivosJava\\" + nombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append(System.lineSeparator()); // Agrega salto de línea
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return contenido.toString();
    }
    
    public void escribirTexto(String direccion, String contenido) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(direccion, true))) {
            writer.write(contenido);
            writer.newLine(); // Agregar un salto de línea después del nuevo contenido
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void guardarCoordenadas(String direccionArchivo, HashMap<String, String> coordenadas){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(direccionArchivo))) {
            for (HashMap.Entry<String, String> entry : coordenadas.entrySet()) {
                String elemento = entry.getKey();
                String info = entry.getValue();
                writer.write("Elemento: " + elemento + ", " + info);
                writer.newLine();
            }
            System.out.println("Coordenadas guardadas en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
