import java.util.ArrayList;
import java.awt.Color;
import java.awt.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Dibuja un teclado QWERTY en pantalla.
 * 
 */
public class Teclado
{
    // instance variables - replace the example below with your own
    private Canvas canvas;
    private ArrayList<Rectangulo> rectangulos;
    private Color color;
    private ArrayList<String> listaLetras;
    private boolean listaLlena;
    private MiMouseAdapter mouseAdapter;

    /**Constructor*/
    public Teclado()
    {
        rectangulos = new ArrayList(26);
        listaLetras = new ArrayList();
        llenarListaLetras();
    }
    
    /***/
    public void dibujarTeclado(Color color)
    {
        int inicioX = 50 + 20;
        int inicioY = 500;
        int x = inicioX;
        int y = inicioY;
        int ancho = 15;
        int alto = 20;
        int separacionX = 25;
        int separacionY = 50;
        for (int i = 0; i < 26; i++)
        {
            rectangulos.add(new Rectangulo(x, y, alto, ancho, canvas, color));
            x += separacionX;
            if ((y == inicioY) && (i == 9))
            {
                x = inicioX + separacionX - 10;
                y += separacionY;
            }
            else if ((y == (inicioY + separacionY)) & (i == 18))
            {
                x = inicioX + (separacionX * 2) - 10;
                y += separacionY; 
            }
        }
        dibujarLetras(Color.black);
    }
    
    /**Dibuja las letras del teclado*/
    public void dibujarLetras(Color color)
    {
        setColor(color);
        int inicioX = 50 + 20;
        int inicioY = 500;
        int x = inicioX;
        int y = inicioY;
        int ancho = 15;
        int alto = 20;
        int separacionX = 25;
        int separacionY = 50;
        for(int i = 0; i < 26; i++)
        {
            canvas.drawString(listaLetras.get(i), x+3, y+16);
            x += separacionX;
            if ((y == inicioY) && (i == 9))
            {
                x = inicioX + separacionX - 10;
                y += separacionY;
            }
            else if ((y == (inicioY + separacionY)) & (i == 18))
            {
                x = inicioX + (separacionX * 2) - 10;
                y += separacionY; 
            }
        }
    }
    
    /**Llena la lista de palabras desde un archivo que contiene todas las letras*/
    private void llenarListaLetras()
    {
        if (!listaLlena)
        {
            File myObj = new File("Lista_Letras.txt");
            try {
            Scanner lector = new Scanner(myObj);
            while (lector.hasNext())
            {
                String letra = lector.nextLine();
                listaLetras.add(letra);
            }
            }
            catch(FileNotFoundException e)
            {
            
            }
            listaLlena = true;
        }
    }
    
    public void setColor(Color color)
    {
        Graphics2D graphic = canvas.getGraphic();
        graphic.setColor(color);
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setCanvas(Canvas canvas)
    {
        this.canvas = canvas;
    }
    
    public Rectangulo getRectangulo(int i)
    {
        return rectangulos.get(i);
    }
    
    /***/
    public String getLetra(int i)
    {
        return listaLetras.get(i);
    }
    
    /**Cambia el color de un rectangulo*/
    public void setRectangulo(int i, Color color)
    {
        rectangulos.set(i, new Rectangulo(rectangulos.get(i).getX(), rectangulos.get(i).getY(), 20, 15, canvas, color));
    }
}