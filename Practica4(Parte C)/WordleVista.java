import java.awt.Color;

public class WordleVista
{
    // Variables
    private Teclado teclado;
    private Rectangulos rectangulos;
    private Canvas canvas;

    /**Constructor de objetos de la clase WordleVista*/
    public WordleVista()
    {
        rectangulos = new Rectangulos();
        teclado = new Teclado();
        
        canvas = new Canvas("Wordle", 400, 650);
        rectangulos.setCanvas(canvas);
        teclado.setCanvas(canvas);
    }

    /**Dibuja toda la vista del Wordle*/
    public void dibujarTablero()
    {
        Color color = Color.lightGray;
        rectangulos.dibujarRectangulos(color);
        teclado.dibujarTeclado(color);
    }
    
    /**Devuelve el canvas*/
    public Canvas getCanvas()
    {
        return canvas;
    }
    
    /**Devuelve el teclado*/
    public Teclado getTeclado()
    {
        return teclado;
    }
    
    /**Devuelve los rectangulos*/
    public Rectangulos getRectangulos()
    {
        return rectangulos;
    }
}