import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private List<FichaDomino> fichasJugadas;

    public Tablero() {
        fichasJugadas = new ArrayList<>();
    }
    
    public void ingresarFichaJugada(FichaDomino ficha){
        fichasJugadas.add(ficha);
    }

    public List<FichaDomino> getFichasJugadas() {
        return fichasJugadas;
    }
    
    public boolean estaVacio() {
        return fichasJugadas.isEmpty();
    }
    
    public boolean mismosPuntosDeAmbosLados(FichaDomino ficha){
        if(ficha.getIzquierdo() == ficha.getDerecho()){
            return true;
        }else{
            return false;
        }
    }
    
    public int obtenerNumeroFichasEnTablero() {
        return fichasJugadas.size();
    }

    public FichaDomino obtenerUltimaFichaJugada() {
        if (!fichasJugadas.isEmpty()) {
            return fichasJugadas.get(fichasJugadas.size() - 1);
        }
        return null;
    }
    
    public String obtenerRepresentacionTablero(int lado) {
        StringBuilder tableroStr = new StringBuilder();
        for (FichaDomino ficha : fichasJugadas) {
            tableroStr.append(ficha.getFicha(lado)).append(" ");
        }   
        return tableroStr.toString();
    }
    
    public boolean haTerminadoElJuego(ArrayList<Jugador> jugadores, Monton boneyard, Tablero tablero) {
        for (Jugador jugador : jugadores) {
            if (jugador.getFichasDelJugador().isEmpty()) {
                return true;
            }
        }
    
        // Verificar si no quedan fichas en el "boneyard" y ningún jugador puede realizar una jugada válida.
        if (boneyard.estaVacio()) {
            boolean noJugadasValidas = true;
            for (Jugador jugador : jugadores) {
                if (tieneJugadaValida(jugador, tablero)) {
                    noJugadasValidas = false;
                    break;
                }
            }
            
            return noJugadasValidas;
        }
        
        return false;
    }
    
    public boolean sePuedeJugar(FichaDomino ficha, int lado) {
        if(lado == 1){// Verifica si el tablero está vacío (primer movimiento)
            if (estaVacio()) {
                return true;
            }
            
            FichaDomino ultimaFicha = obtenerUltimaFichaJugada();
            if (ficha.getIzquierdo() == ultimaFicha.getIzquierdo() || ficha.getDerecho() == ultimaFicha.getIzquierdo()) {
                return true;
            }
            
            return false;
        }
        else if(lado == 2){
            
            if (estaVacio()) {
                return true;
            }
            
            FichaDomino ultimaFicha = obtenerUltimaFichaJugada();
                if (ficha.getIzquierdo() == ultimaFicha.getDerecho() || ficha.getDerecho() == ultimaFicha.getDerecho()) {
                return true;
            }
            
            return false;
        }
        
        return false;
    }
    
    public int OrientacionDeLaFicha(FichaDomino fichaIngresada, int lado)
    {
        int orientacionDeLaPuesta = 0;
        FichaDomino ultimaFicha = obtenerUltimaFichaJugada();
        if(ultimaFicha != null){
            
            if(lado == 1){
                if(estaVacio()){
                    orientacionDeLaPuesta = 0;
                }
                
                if(fichaIngresada.getIzquierdo() == ultimaFicha.getIzquierdo()){
                    orientacionDeLaPuesta = 2;
                }else if(fichaIngresada.getDerecho() == ultimaFicha.getIzquierdo()){
                    orientacionDeLaPuesta = 1;
                }
            }
            
            else if(lado == 2){
                if(estaVacio()){
                    orientacionDeLaPuesta = 0;
                }
    
                if(fichaIngresada.getIzquierdo() == ultimaFicha.getDerecho()){
                    orientacionDeLaPuesta = 1;
                }else if(fichaIngresada.getDerecho() == ultimaFicha.getDerecho()){
                    orientacionDeLaPuesta = 2;
                }
            }
        } else{
            return 0;
        }
        return orientacionDeLaPuesta;
        
    }
    
    private boolean tieneJugadaValida(Jugador jugador, Tablero tablero) {
        List<FichaDomino> fichasJugador = jugador.getFichasDelJugador();
        FichaDomino ultimaFichaTablero = tablero.obtenerUltimaFichaJugada();
    
        // Si el tablero está vacío, cualquier ficha del jugador es válida.
        if (ultimaFichaTablero == null) {
            return true;
        }
    
        // Verificar si alguna ficha del jugador se puede jugar en el tablero.
        for (FichaDomino ficha : fichasJugador) {
            if (ficha.getIzquierdo() == ultimaFichaTablero.getDerecho() || ficha.getDerecho() == ultimaFichaTablero.getDerecho()) {
                return true;
            }
        }
    
        // Si ninguna ficha del jugador se puede jugar, retorna false.
        return false;
    }
}
