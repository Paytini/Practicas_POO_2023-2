import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Colección de métodos útiles.
 * 
 */
public class Metodos
{
    /**Constructor de objetos de la clase Metodos*/
    public Metodos()
    {
        
    }

    /**Devuelve la letra de tipo String que se encuentra en la posicion i del String palabra*/
    public static String obtenerLetrasPalabra(String palabra, int i)
    {
        String letra = "";
        if ((i >= 0) && (i < palabra.length()))
        {
            char[] arregloLetras = palabra.toCharArray();
            letra = "" + arregloLetras[i];
        }
        else
        {
            System.out.println("Solo puede ingresar una posicion que se encuentre entre 1 y la cantidad de caracteres de la palabra ingresada");
            System.out.println(palabra.length());
        }
        return letra;
    }
    
    /**Llena la lista de palabras desde un archivo que contiene todas las letras*/
    private static void llenarListaPalabras(boolean listaLlena, ArrayList<String> lista, String archivo)
    {
        archivo.concat(".txt");
        if (!listaLlena)
        {
            File myObj = new File(archivo);
            try {
            Scanner lector = new Scanner(myObj);
            while (lector.hasNext())
            {
                String letra = lector.nextLine();
                lista.add(letra);
            }
            }
            catch(FileNotFoundException e)
            {
            
            }
            listaLlena = true;
        }
    }
}
