/**
 *
 * @author jolin
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Almacena una lista de palabras.
 * 
 */
public class ListaPalabras
{
    // Atributos
    private ArrayList<String> listaPalabras;
    private String palabraDeLista;
    private boolean listaLlena;

    /**Constructor de objetos de la clase ListaPalabras*/
    public ListaPalabras()
    {
        listaPalabras = new ArrayList();
        listaLlena = false;
        llenarListaPalabras();
    }
    
    /**Llena la lista de palabras desde un archivo que contiene todas las posibles palabras a adivinar*/
    public void llenarListaPalabras()
    {
        int i = 0; 
        if (!listaLlena)
        {
            File myObj = new File("Palabras_Nuevas.txt");
            try
            {
                Scanner lector = new Scanner(myObj);
                while (lector.hasNext())
                {
                    String pal = lector.nextLine();
                    this.listaPalabras.add(pal);
                    System.out.println(i);
                    i++;
                }
                lector.close();
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            listaLlena = true;
        }
    }
    
    /**Devuelve la lista de palabras*/
    public ArrayList<String> getLista()
    {
        return listaPalabras;
    }
    
    /**Devuelve una palabra de la lista*/
    public String getPalabraDeLista()
    {
        if (listaPalabras.isEmpty()) {
            System.out.println("La lista de palabras está vacía.");
            return null; // O devuelve una cadena vacía o maneja el caso de lista vacía según tus necesidades.
        }
    
        Random rdm = new Random();
        int indiceAleatorio = rdm.nextInt(listaPalabras.size());
        String pal = listaPalabras.get(indiceAleatorio);
        System.out.println("Palabra: " + pal + "Numero: " + indiceAleatorio);
        
        palabraDeLista = pal;
        return palabraDeLista;
    }
}