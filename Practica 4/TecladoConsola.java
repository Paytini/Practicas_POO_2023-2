/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordle;

import java.util.Scanner;

/**
 *
 * @author jolin
 */
public class TecladoConsola implements ITeclado {
    
    @Override
    public String getIntento() {
       Scanner in = new Scanner(System.in);
       System.out.print("Ingresa tu Palabra: ");
       return in.nextLine();
    }
    
}
