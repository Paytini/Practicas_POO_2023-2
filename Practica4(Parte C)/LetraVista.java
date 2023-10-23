import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Dibuja en canvas la palabra que se ingresó separandola por caracteres.
 */
public class LetraVista
{
    // instance variables - replace the example below with your own
    private Canvas canvas;
    private int x, y; //Coordenadas para la letra
    private Color color;
    

    /**Contructor de objetos de la clase LetraVista*/
    public LetraVista()
    {
        
    }

    /***/
    public void dibujarPalabraIngresada(ArrayList<String> palabra, int x, int y, int separacion, Color color)
    {
        for (int i = 0; i < 5; i++)
        {
            setColor(color);
            canvas.drawString(palabra.get(i), x+3, y+16);
            x = x + separacion;
        }
    }
    
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    public void setCanvas(Canvas canvas)
    {
        this.canvas = canvas;
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
    
    public int getX()
    {
        return x;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
}