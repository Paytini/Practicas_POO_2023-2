/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica5mastermind;

/**
 *
 * @author jolin
 */
public class Jugador {
    String color1,color2,color3,color4;
    int turno=0;
    boolean ganador=false;

    public Jugador() {
    }
    

    public Jugador(String color1, String color2, String color3, String color4) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }
    public void setGanador(boolean g){
        ganador=g;
    }
    public boolean getGanador(){
        return ganador;
    }
    public void setTurno(){
        turno++;
    }
    public int getTurno(){
        return turno;
    }
    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public String getColor4() {
        return color4;
    }

    public void setColor4(String color4) {
        this.color4 = color4;
    }
    
    
}
