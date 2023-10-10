import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Crea muchos rectangulos en canvas.
 * 
 */
public class Rectangulos
{
    // instance variables - replace the example below with your own
    private Canvas canvas;
    private ArrayList<Rectangulo> rectangulos;
    private Random random;
    private Color color;
    private int x;
    private int y;
    private int ancho;
    private int alto;

    /**Constructor de objetos de la clase Rectangulos*/
    public Rectangulos()
    {
        random = new Random();
        rectangulos = new ArrayList();
    }
     
    /**Dibuja los rectangulos de la palabra en canvas*/
    public void dibujarRectangulos(Color color)
    {
        int inicioX = 50;
        x = inicioX;
        y = 50;
        ancho = 40;
        alto = 50;
        int separacion = 60;
        for (int i = 0; i < 30; i++)
        {
            rectangulos.add(new Rectangulo(x, y, alto, ancho, canvas, color));
            x += separacion;
            if ((i + 1) % 5 == 0)
            {
                x = inicioX;
                y += separacion;
            }
        }
    }
    
    /**Cambia el color de un rectangulo*/
    public void setRectangulo(int i, Color color)
    {
        rectangulos.set(i, new Rectangulo(rectangulos.get(i).getX(), rectangulos.get(i).getY(), 50, 40, canvas, color));
    }
    
    /**Define un color para los rectangulos*/
    public void setColor(Color color)
    {
        Graphics2D graphic = canvas.getGraphic();
        graphic.setColor(color);
    }
    
    /**Obtiene el color de un rectangulo*/
    public Color getColor(int i)
    {
        rectangulos.get(i).getColor();
        return color;
    }
    
    /**Obtiene el canvas*/
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    /**Define el canvas*/
    public void setCanvas(Canvas canvas)
    {
        this.canvas = canvas;
    }
}