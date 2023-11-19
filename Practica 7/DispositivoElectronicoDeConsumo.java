/**
 * Abstract class DispositivoElectronicoDeConsumo - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class DispositivoElectronicoDeConsumo extends DispositivoElectronico
{
    protected boolean encendido;

    public DispositivoElectronicoDeConsumo(String fabricante, String numeroSerie, String marca, String nombre, float costo) {
        super(fabricante, numeroSerie, marca, nombre, costo);
        this.encendido = false; // Por defecto, el dispositivo inicia apagado
    }

    // Getter para isEncendido
    public boolean isEncendido() {
        return encendido;
    }

    // Métodos para encender y apagar el dispositivo
    public void encender() {
        this.encendido = true;
    }

    public void apagar() {
        this.encendido = false;
    }

    // Método toString para representar el objeto como String
    @Override
    public String toString() {
        return super.toString() + ", encendido: " + encendido;
    }
}
