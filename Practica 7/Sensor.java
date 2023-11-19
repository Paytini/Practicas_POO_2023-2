
/**
 * Write a description of class Sensor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sensor extends ComponenteElectronico
{
    // instance variables - replace the example below with your own
    protected final String tipo;
    protected final String unidadDeMedida;
    protected final int valor;

    public Sensor(String fabricante, String numeroSerie, String marca, String nombre, DispositivoElectronico esParteDe, String tipo, String unidadDeMedida, int valor)
    {
        super(fabricante, numeroSerie, marca, nombre, esParteDe);
        this.tipo = tipo;
        this.unidadDeMedida = unidadDeMedida;
        this.valor = valor;
    }
    
    public Sensor(String fabricante, String numeroSerie, String marca, String nombre, String tipo, String unidadDeMedida, int valor)
    {
        super(fabricante, numeroSerie, marca, nombre);
        this.tipo = tipo;
        this.unidadDeMedida = unidadDeMedida;
        this.valor = valor;
    }

    public String getTipo(){
        return this.tipo;
    }
    
    public String getUnidadDeMedida(){
        return this.unidadDeMedida;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    @Override
    public String toString() {
        return "Sensor{" +
                "tipo='" + tipo + '\'' +
                ", unidadDeMedida='" + unidadDeMedida + '\'' +
                ", valor=" + valor +
                ", fabricante='" + fabricante + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", marca='" + marca + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
    
}
