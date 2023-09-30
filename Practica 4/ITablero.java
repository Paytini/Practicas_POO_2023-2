/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.wordle;

import java.util.ArrayList;

/**
 *
 * @author jolin
 */
public interface ITablero {
    public void despliegaIntento(String palabra);
    public boolean revisarPalabra(String palabra);
    public int determinarRespuesta(String palabra, String respuesta);
    public void mostrarPalabrasEscritas(ArrayList<String> palabras);
}
