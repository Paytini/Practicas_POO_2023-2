/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica5mastermind;

/**
 * Clase que modela las banderas de aciertos del juego
 *
 * @version 24/10/22
 * @author Jolin
 */
public class Bandera {
    
    private String[] pines; //Son los pines de colores
    
    public Bandera(){
        pines = new String[6];
        inicializar();
    }
    
    // Regresa un pin
    public String getPin(int posicion){
        return pines[posicion];
    }
    
    // Cambia el pin de una cierta posicion
    public void setPin(int posicion, String pin){
        pines[posicion]=pin;
    }
    
    // Se encarga de Inicializar todos los pines 
    public void inicializar(){
        for(int i=0;i<pines.length;i++){
            pines[i]="Gray";
        }
    }
    
}
