import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JuegoOAJ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Monton boneyard = new Monton();
        Tablero tablero = new Tablero();
        ArrayList<FichaDomino> fichasDelJuego = new ArrayList<>();

        System.out.println("<<<<<Bienvenido al juego de dominó >>>>>");
        
        System.out.println("[JUGADORES]");
        System.out.println("Ingrese el número de jugadores (2-10): ");
        int numeroJugadores = scanner.nextInt();
        
        System.out.println("[PUNTAJE]");
        System.out.println("Ingrese el puntaje a ganar: ");
        int puntaje = scanner.nextInt();
        if (numeroJugadores < 2 || numeroJugadores > 10) {
            System.out.println("Número de jugadores no válido.");
            return;
        }

        if (numeroJugadores >= 2 && numeroJugadores <= 10) {
            int mulaMasGrande = 6;

            if (numeroJugadores >= 4 && numeroJugadores <= 6) {
                mulaMasGrande = 9;
            } else if (numeroJugadores >= 7 && numeroJugadores <= 10) {
                mulaMasGrande = 12;
            }

            for (int i = 0; i <= mulaMasGrande; i++) {
                for (int j = i; j <= mulaMasGrande; j++) {
                    FichaDomino ficha = new FichaDomino(i, j);
                    fichasDelJuego.add(ficha);
                }
            }
            
            Collections.shuffle(fichasDelJuego);
        }

        System.out.println("[NOMBRE DE LOS JUGADORES]");
        // Repartir fichas a los jugadores
        for (int i = 0; i < numeroJugadores; i++) {
            ArrayList<FichaDomino> fichasJugador = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                FichaDomino ficha = fichasDelJuego.remove(0);
                fichasJugador.add(ficha);
            }
            System.out.print("Nombre del Jugador " + (i + 1) + ": ");
            String nombre = scanner.next();
            Jugador jugador = new Jugador(fichasJugador, nombre);
            jugadores.add(jugador);
        }
        
        // Mandamos las fichas sobrantes a boneyard
        for(int x = 0; x < fichasDelJuego.size(); x++){
                boneyard.agregarFichaBoneyard(fichasDelJuego.remove(0));
        }
        System.out.println("[LADO A JUGAR]");
        System.out.println("Seleccione de que lado se jugará:" + "\n" + "1. Izquierdo" + "\n"
                             + "2. Derecho");
        System.out.println("elija: ");
        int lado = scanner.nextInt();
        System.out.println("\n\nINICIAMOS DOMINO!!");
        
        
        boolean juegoTerminado = false;
        Jugador jugadorActual = jugadores.get(0);
        int ronda = 0;
        int ladoEnQueSePondra = 0;
        
        // Main del juego de domino
        while(!juegoTerminado){
            ronda = 0;
            while(ronda != numeroJugadores){
                System.out.println("\n\n<<<<<< Turno de " + jugadorActual.nombreJugador() + ">>>>>>");
                jugadorActual.mostrarFichas();
                
                boolean puedeJugar = false;
                for (FichaDomino ficha : jugadorActual.getFichasDelJugador()) {
                    if (tablero.sePuedeJugar(ficha,lado)) {
                        puedeJugar = true;
                        //System.out.println("Si se puede");
                        break;
                    }
                }
                
                if(puedeJugar){
                    boolean fichaValida = false;
                    while(!fichaValida){
                        
                        System.out.println("Seleccione una ficha para jugar: ");
                        int indiceFicha = scanner.nextInt();
                        FichaDomino fichaJugada = jugadorActual.getFichasDelJugador().get(indiceFicha - 1);
                      
                        if (tablero.sePuedeJugar(fichaJugada,lado)) {
                            ladoEnQueSePondra = tablero.OrientacionDeLaFicha(fichaJugada,lado);
                            System.out.println(jugadorActual.nombreJugador() + " jugó la ficha: " + fichaJugada.getFicha(ladoEnQueSePondra));
                            tablero.ingresarFichaJugada(fichaJugada);
                            jugadorActual.quitarFichar(fichaJugada);
                            
                            if(tablero.mismosPuntosDeAmbosLados(fichaJugada)){
                                System.out.println("Ingresastes un double!");
                                boolean correcto = false;
                                while(!correcto){
                                    System.out.println("Tienes dos opciones:" + "\n" + "1. Agregar otra ficha"
                                                    + "\n" + "2. Pasar al otro jugador");
                                    System.out.println("Que eliges: ");
                                    int opcion = scanner.nextInt();
                                    
                                    switch(opcion){
                                        case 1:
                                            boolean fichasValidas = false;
                                            for (FichaDomino ficha : jugadorActual.getFichasDelJugador()) {
                                                if (tablero.sePuedeJugar(ficha,lado)) {
                                                    fichasValidas = true;
                                                    break;
                                                }
                                            }
                                            
                                            if(fichasValidas){
                                                jugadorActual.mostrarFichas();
                                                System.out.println("Seleccione una ficha para jugar: ");
                                                indiceFicha = scanner.nextInt();
                                                fichaJugada = jugadorActual.getFichasDelJugador().get(indiceFicha - 1);
                                                System.out.println(jugadorActual.nombreJugador() + " jugó la ficha: " + fichaJugada.getFicha(ladoEnQueSePondra));
                                                tablero.ingresarFichaJugada(fichaJugada);
                                                jugadorActual.quitarFichar(fichaJugada);
                                                correcto =  true;
                                            }else{
                                                System.out.println("No puedes jugar ninguna de las que tienes,pasamos al otro jugador");
                                                correcto = true;
                                            }
                                            break;
                                            
                                        case 2:
                                            System.out.println("Pasamos al otro jugador");
                                            correcto = true;
                                            break;
                                            
                                        default:
                                            correcto = false;
                                            break;
                                    }
                                }
                            }
                            fichaValida = true;
                        } else {
                            fichaValida = false;
                            System.out.println("No se puede jugar esa ficha. Intente nuevamente.");
                        }
                  }
                }
                else{
                      while (!boneyard.estaVacio()) {
                            System.out.println("\n[USAMOS BONEYARD]");
                            FichaDomino fichaDelBoneyard = boneyard.agarrarFicha();
                            jugadorActual.tomarFicha(fichaDelBoneyard);
                            System.out.println(jugadorActual.nombreJugador() + " tomó una ficha del boneyard.");
                            System.out.println("Se le agregó la ficha " + fichaDelBoneyard.getFicha(ladoEnQueSePondra));
                
                            // Verificar si el jugador puede hacer una jugada después de tomar una ficha
                            boolean fichaValida = false;
                            for (FichaDomino ficha : jugadorActual.getFichasDelJugador()) {
                                if (tablero.sePuedeJugar(ficha,lado)) {
                                    fichaValida = true;
                                    break;
                                }
                            }
                
                            if (fichaValida) {
                                // El jugador puede hacer una jugada válida después de tomar una ficha
                                int tamano = jugadorActual.getFichasDelJugador().size();
                                FichaDomino fichaJugada = jugadorActual.getFichasDelJugador().get(tamano - 1);
                                System.out.println(jugadorActual.nombreJugador() + " jugó la ficha: " + fichaJugada.getFicha(ladoEnQueSePondra));
                                tablero.ingresarFichaJugada(fichaJugada);
                                jugadorActual.quitarFichar(fichaJugada);
                                break;
                            } else {
                               // System.out.println("El jugador no puede jugar y sigue tomando fichas del boneyard.");
                            }
                        }
                
                      if (boneyard.estaVacio()) {
                            System.out.println("AVISO!!!" + "\n" + jugadorActual.nombreJugador() + " no puede jugar y el boneyard está vacío.");
                      }
                }
                System.out.println("\n[TABLERO DEL JUEGO]");
                System.out.println(tablero.obtenerRepresentacionTablero(ladoEnQueSePondra));
                ronda++;
                int indiceSiguienteJugador = (jugadores.indexOf(jugadorActual) + 1) % jugadores.size();
                jugadorActual = jugadores.get(indiceSiguienteJugador);
            }
            
            calcularPuntajeRonda(jugadores);
            imprimirPuntajes(jugadores);
            
            for (Jugador jugador : jugadores) {
                if (jugador.getPuntos() >= puntaje) {
                    System.out.println("\n[GANADOR!!]");
                    System.out.println("¡El ganador del juego es " + jugador.nombreJugador() + "!");
                    juegoTerminado = true;
                }
            }
        }
    }
    
    
    // Función para calcular el puntaje de la ronda
    private static void calcularPuntajeRonda(ArrayList<Jugador> jugadores) {
        int puntajeMinimo = Integer.MAX_VALUE;
        Jugador ganadorRonda = null;
        int acum = 0;
    
        for (Jugador jugador : jugadores) {
            int puntaje = jugador.calcularPuntajeRonda();
            if (puntaje < puntajeMinimo) {
                puntajeMinimo = puntaje;
                ganadorRonda = jugador;
            }
        }
        
        for (Jugador jugador : jugadores){
            if(jugador != ganadorRonda){
                acum += jugador.calcularPuntajeRonda();
            }
        }
        
        for (Jugador jugador : jugadores){
            if(jugador == ganadorRonda){
                jugador.setPuntos(acum);
            }
        }
        // Restar el puntaje del ganador de la ronda a los otros jugadores
        for (Jugador jugador : jugadores) {
            if (jugador != ganadorRonda) {
                jugador.restarPuntajeRonda(puntajeMinimo);
            }
        }
    }
    
     private static void imprimirPuntajes(ArrayList<Jugador> jugadores) {
        System.out.println("\n[CALCULOS DE LA RONDA]");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.nombreJugador() + ": " + jugador.getPuntos());
        }
    }

    
}
