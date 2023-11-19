
/**
 * Write a description of class Pantalla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pantalla extends ComponenteElectronico
{
    // instance variables - replace the example below with your own
    protected final int resolucionX;
    protected final int resolucionY;
    
    public Pantalla(String fabricante, String numeroSerie, String marca, String nombre, DispositivoElectronico esParteDe, int resolucionX, int resolucionY){
        super(fabricante, numeroSerie, marca, nombre, esParteDe);
        this.resolucionX = resolucionX;
        this.resolucionY = resolucionY;
    }
    
    public Pantalla(String fabricante, String numeroSerie, String marca, String nombre,int resolucionX, int resolucionY){
        super(fabricante, numeroSerie, marca, nombre);
        this.resolucionX = resolucionX;
        this.resolucionY = resolucionY;
    }
    
    public int getResolucionX(){
        return this.resolucionX;
    }
    
    public int getResolucionY(){
        return this.resolucionY;
    }
    
    @Override
    public String toString() {
        return "Pantalla{" +
                "resolucionX=" + resolucionX +
                ", resolucionY=" + resolucionY +
                ", fabricante='" + fabricante + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", marca='" + marca + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
