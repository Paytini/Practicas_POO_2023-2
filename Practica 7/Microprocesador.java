
/**
 * Write a description of class Microprocesador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Microprocesador extends ComponenteElectronico
{
    protected final int cacheRAM;
    protected final long velocidadHz;
    
    public Microprocesador(String fabricante, String numeroSerie, String marca, String nombre, DispositivoElectronico esParteDe,
                           int cacheRAM, long velocidadHz) {
        super(fabricante, numeroSerie, marca, nombre, esParteDe);
        this.cacheRAM = cacheRAM;
        this.velocidadHz = velocidadHz;
    }
    
    public Microprocesador(String fabricante, String numeroSerie, String marca, String nombre,
                           int cacheRAM, long velocidadHz) {
        super(fabricante, numeroSerie, marca, nombre);
        this.cacheRAM = cacheRAM;
        this.velocidadHz = velocidadHz;
    }
    
    // Getters para cacheRAM y velocidadHz (atributos inmutables)
    public int getCacheRAM() {
        return cacheRAM;
    }

    public long getVelocidadHz() {
        return velocidadHz;
    }

    // Método toString 
    @Override
    public String toString() {
        return "Microprocesador{" +
                "cacheRAM=" + cacheRAM +
                ", velocidadHz=" + velocidadHz +
                '}';
    }
}
