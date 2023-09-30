/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.wordle;


/**
 *
 * @author jolin
 */
public class Wordle {

    public static void main(String[] args) {
        ITablero tablero = new TableroHolografica();
        ITeclado teclado = new TecladoConsola();
      //  tablero.determinarRespuesta("Hola", "Halo");
        JuegoWordle juego = new JuegoWordle(tablero, teclado);
        
        System.out.println("INICIAMOS WORDLE!!!\n");
        juego.jugar();
        System.out.println("GRACIAS POR HABER JUGADO");
    }
}
