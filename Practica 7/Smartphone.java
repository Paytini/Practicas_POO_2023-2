
/**
 * Write a description of class Smartphone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smartphone extends DispositivoElectronicoDeConsumo {
    private final Sensor sensorDeHuella;
    private final Pantalla pantalla;

    public Smartphone(String fabricante, String numeroSerie, String marca, String nombre, float costo, Sensor sensorDeHuella, Pantalla pantalla) {
        super(fabricante, numeroSerie, marca, nombre, costo);
        this.sensorDeHuella = sensorDeHuella;
        this.pantalla = pantalla;
    }

    public Sensor getSensorDeHuella() {
        return sensorDeHuella;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }
    
    @Override
    public String toString() {
        return "Smartphone{" +
                "fabricante='" + getFabricante() + '\'' +
                ", numeroSerie='" + getNumeroSerie() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", costo=" + getCosto() +
                ", sensorDeHuella=" + sensorDeHuella +
                ", pantalla=" + pantalla +
                '}';
    }
}
