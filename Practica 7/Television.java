
/**
 * Write a description of class Television here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Television extends DispositivoElectronicoDeConsumo {
    private final Pantalla pantalla;

    public Television(String fabricante, String numeroSerie, String marca, String nombre, float costo, Pantalla pantalla) {
        super(fabricante, numeroSerie, marca, nombre, costo);
        this.pantalla = pantalla;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }
    
    @Override
    public String toString() {
        return "Television{" +
                "fabricante='" + getFabricante() + '\'' +
                ", numeroSerie='" + getNumeroSerie() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", costo=" + getCosto() +
                ", pantalla=" + pantalla +
                '}';
    }
}