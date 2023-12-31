
/**
 * Write a description of class FichaDomino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FichaDomino
{
    // instance variables - replace the example below with your own
    private int ladoIzquierdo;
    private int ladoDerecho;
    private boolean orientacion; 

    /**
     * Constructor for objects of class FichaDomino
     */
    public FichaDomino()
    {
        // initialise instance variables
        this.ladoIzquierdo = 0;
        this.ladoDerecho = 0;
        this.orientacion = false;
    }
    
    /*
     * Este constructor nos servira mucho para la creacion de las fichas personalizadas
     */
    public FichaDomino(int newIzquierdo, int newDerecho){
        this.ladoIzquierdo = newIzquierdo;
        this.ladoDerecho = newDerecho;
        if(this.ladoIzquierdo == this.ladoDerecho){
            this.orientacion = true;
        }else{
            this.orientacion = false;
        }
    }
    
    /*
     * Lo siguientes son metodos donde interactuan con las variables de los lados
     * de las fichas, getters and setters.
     */

    public void setIzquierdo(int numero)
    {
        this.ladoIzquierdo = numero;  
    }
    
    public void setDerecho(int numero)
    {
        this.ladoDerecho = numero;  
    }
    
    public int getIzquierdo()
    {
        return this.ladoIzquierdo; 
    }
    
    public int getDerecho()
    {
        return this.ladoDerecho; 
    }
    
    public String getFicha(int lado){
        if(lado == 1){
            return "[" + this.ladoIzquierdo + "|" + this.ladoDerecho + "]";
        }else if(lado == 2){
            return "[" + this.ladoDerecho + "|" + this.ladoIzquierdo + "]";

        }
        
        return "[" + this.ladoIzquierdo + "|" + this.ladoDerecho + "]";
    }
}
