import java.util.ArrayList;

/**
 * Almacena una palabra de caracteres.
 * 
 */
public class Palabra
{
    // Atributos
    private String palabra;
    private ArrayList<String> palabraDividida; //Almacena la palabra separada, cada caracter es independiente
    private boolean palabraIniciada;

    /**Constructor de objetos de la clase Palabra*/
    public Palabra(String pal)
    {
        this.palabra = pal;
        palabraDividida = new ArrayList();
        palabraIniciada = false;
        inicializarPalabraDividida();
    }

    /***/
    private void inicializarPalabraDividida()
    {
        if (!palabraIniciada)
        {
            for (int i = 0; i < 5; i++)
            {
                palabraDividida.add("");
            }
            palabraIniciada = true;
        }
    }
    
    /**Separa la palabra en sus caracteres para ser manipulados de forma independiente*/
    public ArrayList<String> dividirPalabra()
    {
        for (int i = 0; i < 5; i++)
        {
            palabraDividida.set(i, Metodos.obtenerLetrasPalabra(palabra, i)); //Se va llenando palabraDividida con los caracteres de palabra
        }
        return palabraDividida;
    }
    
    public void setPalabra(String palabra)
    {
        this.palabra = palabra;
    }
    
    public String getPalabra()
    {
        return palabra;
    }
    
    public void setPalabraDividida(ArrayList<String> palabraDividida)
    {
        this.palabraDividida = palabraDividida;
    }
    
    public ArrayList<String> getPalabraDividida()
    {
        return palabraDividida;
    }
}
