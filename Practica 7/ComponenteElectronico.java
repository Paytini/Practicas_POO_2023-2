/**
 * Abstract class ComponenteElectronico - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class ComponenteElectronico extends DispositivoElectronico
{
    // Atributo mutable
    protected DispositivoElectronico esParteDe;
    
    public ComponenteElectronico(String fabricante, String numeroSerie, String marca, String nombre, DispositivoElectronico esParteDe) {
        super(fabricante,numeroSerie,marca,nombre);
        this.esParteDe = esParteDe;
    }
    
    public ComponenteElectronico(String fabricante, String numeroSerie, String marca, String nombre) {
        super(fabricante,numeroSerie,marca,nombre);
    }

    // Setter y getter para esParteDe
    public void setEsParteDe(DispositivoElectronico esParteDe) {
        this.esParteDe = esParteDe;
    }

    public DispositivoElectronico getEsParteDe() {
        return esParteDe;
    }
    
    // Método toString 
    @Override
    public String toString() {
        return "ComponenteElectronico{" +
                "esParteDe=" + esParteDe +
                '}';
    }
}
