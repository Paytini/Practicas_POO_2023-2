import java.util.ArrayList;
import java.awt.Color;
import java.util.Scanner;

public class Wordle
{
    // Variables
    private WordleLogica logica;
    private WordleVista vista;
    private LetraVista letraVista;
    private Canvas canvas;
    
    private int intento;
    
    private boolean inicioAciertos;
    private boolean palabraAcertada;
    
    private ArrayList<Boolean> letrasPerfectas; //Cantidad de letras perfectamente adivinadas
    private ArrayList<Boolean> letrasCorrectas; //Cantidad de letras adivinadas

    /**Constructor de objetos de la clase  Wordle*/
    public Wordle()
    {
        logica = new WordleLogica();
        vista = new WordleVista();
        letraVista = new LetraVista();
        letrasPerfectas = new ArrayList();
        letrasCorrectas = new ArrayList();
        
        /*Inicializando los ArrayList de las coincidencias*/
        inicioAciertos = false;
        logica.inicializarCoincidencias(letrasPerfectas, letrasCorrectas);
        
        letraVista.setCanvas(vista.getCanvas());
        logica.obtenerPalabraABuscar();
        vista.dibujarTablero();
        intento = 0;
        palabraAcertada = false;
    }

    /**Reinicia el juego Wordle*/
    public void reset()
    {
        vista.getCanvas().erase();
        logica.obtenerPalabraABuscar();
        todoFalso();
        vista.dibujarTablero();
        intento = 0;
        palabraAcertada = false;
    }
    
    /**Dibuja la palabra ingresada con los colores correspondientes*/
    public void adivinarPalabra()
    {
        boolean adivinado = false;
        while (intento < 6 && !adivinado)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingresa una palabra a adivinar");
            String palabra = scan.next();
            palabra = palabra.toUpperCase();
            todoFalso();
            logica.adivinarPalabra(palabra, letrasPerfectas, letrasCorrectas);
            //Dibujando la palabra
            Color color = Color.white;
            int y = 60;
            if (intento == 0)
            {
                letraVista.dibujarPalabraIngresada(logica.getPalabraIngresada(), 60, y, 60, color);
            }
            else if (intento == 1)
            {
                y = y + (60);
                letraVista.dibujarPalabraIngresada(logica.getPalabraIngresada(), 60, y, 60, color);
            }
            else if (intento == 2)
            {
                y = y + (60*2);
                letraVista.dibujarPalabraIngresada(logica.getPalabraIngresada(), 60, y, 60, color);
            }
            else if (intento == 3)
            {
                y = y + (60*3);
                letraVista.dibujarPalabraIngresada(logica.getPalabraIngresada(), 60, y, 60, color);
            }
            else if (intento == 4)
            {
                y = y + (60*4);
                letraVista.dibujarPalabraIngresada(logica.getPalabraIngresada(), 60, y, 60, color);
            }
            else if (intento == 5)
            {
                y = y + (60*5);
                letraVista.dibujarPalabraIngresada(logica.getPalabraIngresada(), 60, y, 60, color);
            }
            
            //Continuando con la adivinacion de la palabra
            indicarCorrectos(letrasPerfectas, letrasCorrectas, intento, y, color);
            adivinado = palabraAdivinada(letrasPerfectas);
            indicarQueGano(adivinado);
            intento++;
        }
        if (intento >= 6)
            {
                System.out.println("Ya no puedes intentar adivinar la palabra");
                System.out.println("La palabra a adivinar era: " + logica.getPalabraDelDia());
            }
    }
    
    /**Indica con colores si la letra pertenece o no a la palabra del dia
       *Gris oscuro = La letra no pertenece a la palabra
       *Verde = La letra pertenece a la palabra y esta en la posicion correcta
       *Amarillo = La letra pertenece a la palbra pero no se encuentra en la posicion correcta*/
    public void indicarCorrectos(ArrayList<Boolean> letrasPerfectas, ArrayList<Boolean> letrasCorrectas, int intento, int y, Color colorR)
    {
        Color color;
        int caso = -1;
        for(int i = 0; i < 5; i++)
        {
            if (letrasPerfectas.get(i))
            {
                caso = 1;
                color = Color.green;
            }
            else if (letrasCorrectas.get(i))
            {
                caso = 2;
                color = Color.orange;
            }
            else
            {
                caso = 0;
                color = Color.darkGray;
            }
            vista.getRectangulos().setRectangulo((5*intento)+i, color);
            indicarCorrectosTeclado(caso, i);
        }
        letraVista.dibujarPalabraIngresada(logica.getPalabraIngresada(), 60, y, 60, colorR);
        
    }
    
    /***/
    public void indicarCorrectosTeclado(int caso, int i)
    {
        Color color = Color.black;
        if (caso == 1)
        {
            color = Color.green;
        }
        else if (caso == 2)
        {
            color = Color.orange;
        }
        else if (caso == 0)
        {
            color = Color.darkGray;
        }
        
        for (int j = 0; j < 26; j++)
        {
            if (logica.getPalabraIngresada().get(i).compareTo(vista.getTeclado().getLetra(j)) == 0)
            {
                vista.getTeclado().setRectangulo(j, color);
            }
        }
        vista.getTeclado().dibujarLetras(Color.white);
    }
    
    /**Si se adivinó la palabra del día, indicará al usuario que ha acertado*/
    public boolean palabraAdivinada(ArrayList<Boolean> letrasPerfectas)
    {
        boolean adivinado = false;
        int correctas = 0;
        for (int i = 0; i < 5; i++)
        {
            if (letrasPerfectas.get(i))
            {
                correctas++;
            }
        }
        if (correctas == 5)
        {
            adivinado = true;
        }
        return adivinado;
    }
    
    /**Indicará al usuario en la consola que ha adivinado la palabra del día, en caso de ser así*/
    public void indicarQueGano(boolean adivinado)
    {
        if (adivinado)
        {
            System.out.println("Ha adivinado la palabra del día: " + logica.getPalabraDelDia());
            intento = 6;
        }
    }
    
    /***/
    public void todoFalso()
    {
        for (int i = 0; i < 5; i++)
        {
            letrasPerfectas.set(i, false);
            letrasCorrectas.set(i, false);
        }
    }
}