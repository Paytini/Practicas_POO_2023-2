
/**
 * Write a description of class Computadora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computadora extends DispositivoElectronicoDeConsumo {
    private Microprocesador cpu;
    private long ramMB;

    public Computadora(String fabricante, String numeroSerie, String marca, String nombre,float costo, Microprocesador cpu, long ramMB) {
        super(fabricante, numeroSerie, marca, nombre, costo);
        this.cpu = cpu;
        this.ramMB = ramMB;
    }

    public Microprocesador getCpu() {
        return cpu;
    }

    public void setCpu(Microprocesador cpu) {
        this.cpu = cpu;
    }

    public long getRamMB() {
        return ramMB;
    }

    public void setRamMB(long ramMB) {
        this.ramMB = ramMB;
    }
    
    @Override
    public String toString() {
        return "Computadora{" +
                "fabricante='" + getFabricante() + '\'' +
                ", numeroSerie='" + getNumeroSerie() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", costo='" + getCosto() + '\'' +
                ", cpu=" + cpu +
                ", ramMB=" + ramMB +
                '}';
    }
}
