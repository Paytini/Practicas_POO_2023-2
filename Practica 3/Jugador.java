import java.util.ArrayList;

public class Jugador
{
    private ArrayList<FichaDomino> fichasDelJugador;
    private String nombre;
    private int puntos;
    public Jugador()
    {
        fichasDelJugador = new ArrayList<>();
        nombre = "";
        puntos = 0;

    }
    
    public Jugador(ArrayList<FichaDomino> fichas, String newName){
        this.nombre = newName;
        this.fichasDelJugador = new ArrayList<>(); 
        fichasDelJugador.addAll(fichas);
        puntos = 0;
    }

     // Método para obtener las fichas del jugador
    public ArrayList<FichaDomino> getFichasDelJugador() {
        return fichasDelJugador;
    }
    
    public void mostrarFichas() {
        System.out.println("Fichas del jugador " + nombre + ":");
        for (int i = 0; i < fichasDelJugador.size(); i++) {
            System.out.println("Ficha " + (i + 1) + ": " + fichasDelJugador.get(i).getFicha(1));
        }
    }
    
    public String nombreJugador(){
        return this.nombre;
    }
    
    public void setPuntos(int newPuntos){
        this.puntos+=newPuntos;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
    public void setNombre(String newName){
        this.nombre = newName;
    }
    
    // Método para que el jugador tome una ficha
    public void tomarFicha(FichaDomino ficha) {
        fichasDelJugador.add(ficha);
    }
    
    /*
     * Este metodo servira pra cuando el jugador haya jugado una ronda en el tablero, 
     * entonces alli se eliminara la ficha de su arreglo.
     */
    public void quitarFichar(FichaDomino ficha){
        if (!fichasDelJugador.isEmpty()){
            fichasDelJugador.remove(ficha); 
        } else{
            System.out.println("La lista está vacía. No puedes borrar más elementos.");
        }
    }  
    
    public int calcularPuntajeRonda() {
        int puntajeRonda = 0;
        
        for (FichaDomino ficha : fichasDelJugador) {
            puntajeRonda += ficha.getIzquierdo() + ficha.getDerecho();
        }
        
        return puntajeRonda;
    }
    
    public void restarPuntajeRonda(int puntajeRondaGanada) {
        puntos -= puntajeRondaGanada;
        if (puntos < 0) {
            puntos = 0;
        }
    }

}
