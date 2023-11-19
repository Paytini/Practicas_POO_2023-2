import java.util.ArrayList;

/**
 * Abstract class DispositivoElectronico - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class DispositivoElectronico
{
    // Atributos inmutables
    protected final String fabricante;
    protected final String numeroSerie;
    protected final String marca;
    protected final String nombre;
    // Atributos mutables
    protected float costo;
    protected ArrayList<ComponenteElectronico> componentes;
    
    // Constructor con mutables
    public DispositivoElectronico(String fabricante, String numeroSerie, String marca, String nombre, float costo) {
        this.fabricante = fabricante;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.nombre = nombre;
        this.costo = costo;
        this.componentes = new ArrayList<>();
    }
    
    // Constructor sin mutables
    public DispositivoElectronico(String fabricante, String numeroSerie, String marca, String nombre) {
        this.fabricante = fabricante;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.nombre = nombre;
    }
        
    // Getters para atributos inmutables
    public String getFabricante() {
        return this.fabricante;
    }

    public String getNumeroSerie() {
        return this.numeroSerie;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    // Setters y getters para el costo
    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getCosto() {
        return costo;
    }

    // Setters y getters para los componentes
    public void agregarComponente(ComponenteElectronico componente) {
        componentes.add(componente);
    }

    public void quitarComponente(ComponenteElectronico componente) {
        componentes.remove(componente);
    }

    public ArrayList<ComponenteElectronico> getComponentes() {
        return componentes;
    }
    
    // Método toString sobrescrito
    @Override
    public String toString() {
        return "DispositivoElectronico{" +
                "fabricante='" + fabricante + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", marca='" + marca + '\'' +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", componentes=" + componentes +
                '}';
    }
    
    // Método que se ejecuta al hacer clic
    public void alHacerClic() {
        // Este método se sobrescribirá en las clases hijas
        System.out.println("Clic en el dispositivo electrónico.");
    }
}
