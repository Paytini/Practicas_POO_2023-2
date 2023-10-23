import java.util.ArrayList;
import java.util.Random;
import java.lang.Boolean;

/**
 * Parte lógica del juego Wordle.
 */
public class WordleLogica
{
    // Atributos
    private boolean inicioPalabras;
    private boolean inicioCoincidencias;
    private boolean palabraObtenida;
    
    private ListaPalabras listaPalabras; //La lista de palabras de la cual se obtiene una palabra
    private ArrayList<String> listaDePalabras; //La lista de palabras obtenida
    
    private ArrayList<String> palabraIngresada; //Palabra que ingresamos para intentahor adivinar, separada por caracteres
    private ArrayList<String> palabraDelDia; //Palabra que tenemos que adivinar, separada por caracteres
    
    private String palabraIng; //Palabra que ingresamos para intentar adivinar
    private String palabraDia; //Palabra que tenemos que adivinar
    
    private ArrayList<Boolean> sinCoincidencias1;
    private ArrayList<Boolean> sinCoincidencias2;

    /**Constructor de objetos de la clase  WordleLogica*/
    public WordleLogica()
    {
        /*Creando objetos*/
        palabraIngresada = new ArrayList();
        palabraDelDia = new ArrayList();
        sinCoincidencias1 = new ArrayList();
        sinCoincidencias2 = new ArrayList();
        listaPalabras = new ListaPalabras();
        
        /*Inicializando los ArrayList de las palabras*/
        inicioCoincidencias = false;
        palabraIngresada = inicializarPalabras(palabraIngresada);
        inicioCoincidencias = false;
        palabraDelDia = inicializarPalabras(palabraDelDia);
        palabraObtenida = false;
    }

    /**Inicializa la lista booleana de 5 elementos en false cada elemento
      *Solo se puede ingresar una sola vez*/
    public void inicializarCoincidencias(ArrayList<Boolean> sinCoincidencias1, ArrayList<Boolean> sinCoincidencias2)
    {
        if (!inicioCoincidencias) //Si se ingresó previamente, no volverá a ingresar
        {
            for (int i = 0; i < 5; i++)
            {
                sinCoincidencias1.add(false);
                sinCoincidencias2.add(false);
            }
            inicioCoincidencias = true;
        }
        //return sinCoincidencias;
    }
    
    /**Inicializa la palabra dividida con 5 caracteres vacios de tipo String para posteriormente ser llenado
      *Solo se puede ingresar una vez*/
    private ArrayList<String> inicializarPalabras(ArrayList<String> palabraDividida)
    {
        if (!inicioPalabras)
        {
            for (int i = 0; i < 5; i++)
            {
                palabraDividida.add("");
            }
        }
        return palabraDividida;
    }
    
    /**Divide la palabra en sus caracteres en forma de un ArrayList<String>*/
    public ArrayList<String> dividirPalabra(String palabra, ArrayList<String> palabraDividida)
    {
        for (int i = 0; i < 5; i++)
        {
            palabraDividida.set(i, Metodos.obtenerLetrasPalabra(palabra, i));
        }
        return palabraDividida;
    }
    
    /**Obtiene la palabra a buscar de la lista de palabras y la divide en caracteres de tipo String*/
    public ArrayList<String> obtenerPalabraABuscar()
    {
        palabraDia = listaPalabras.getPalabraDeLista(); //Se obtiene la palabra a buscar de la listaPalabras
        palabraDelDia = dividirPalabra(palabraDia, palabraDelDia); //Divide la palabra de listaPalabras en sus caracteres
        return palabraDelDia;
    }
    
    
    /**Muestra las letras de la palabra*/
    public void mostrarLetras(ArrayList<String> palabraDividida)
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.print(palabraDividida.get(i) + " ");
        }
    }
    
    /**Pide una palabra, si encuentra caracteres iguales y en la misma posicion, indicará que son letras perfectas (verde)*/
    public void adivinarPalabra(String palabraAdivinar, ArrayList<Boolean> letrasPerfectas, ArrayList<Boolean> letrasCorrectas)
    {
        palabraIngresada = dividirPalabra(palabraAdivinar, palabraIngresada); // Divide la palabra ingresada, para poder ser comparada
        palabraDelDia = dividirPalabra(palabraDia, palabraDelDia); //La palabra del dia se divide en caracteres de tipo String
        for (int i = 0; i < 5; i++)
        {
            if (palabraIngresada.get(i).compareTo(palabraDelDia.get(i)) == 0)
            {
                letrasPerfectas.set(i, true);
            }
            else
            {
                letrasPerfectas.set(i, false);
            }
        }
        letrasCorrectas(letrasPerfectas, letrasCorrectas);
    }
    
    /**Define qué letras son correctas pero no están en su posición correcta*/
    public void letrasCorrectas(ArrayList<Boolean> letrasPerfectas, ArrayList<Boolean> letrasCorrectas)
    {
        for (int i = 0; i < 5; i++) //Doble ciclo para determinar las letras correctas en posicion incorrecta
        {
            if (!letrasPerfectas.get(i))
            {
                for (int j = 0; j < 5; j++)
                {
                    if (palabraIngresada.get(i).compareTo(palabraDelDia.get(j)) == 0)
                    {
                        letrasCorrectas.set(i, true);
                    }
                    else
                    {
                        letrasCorrectas.set(i, false);
                    }
                }
            }
        }
    }
    
    /**Devuelve la palabra ingresada*/
    public ArrayList<String> getPalabraIngresada()
    {
        return palabraIngresada;
    }
    
    /**Devuelve la palabra del dia*/
    public ArrayList<String> getPalabraDelDia()
    {
        return palabraDelDia;
    }
}