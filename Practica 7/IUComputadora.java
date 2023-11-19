import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class IUComputadora extends JPanel {
    private BufferedImage image;
    private Computadora computadora;

    public IUComputadora(String nombreImagen, Computadora computadora) {
        try {
            image = ImageIO.read(new File(nombreImagen)); // Se lee la imagen
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.computadora = computadora;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                // Verificar si se hizo clic dentro del área del dispositivo (ejemplo)
                if (x >= 10 && x <= 60 && y >= 10 && y <= 60) {
                    //System.out.println("Haz hecho clic en la computadora: " + computadora.getNombre());
                    // Aquí se accede a los atributos del dispositivo y mostrarlos en la consola
                    System.out.println(computadora.toString());
                }
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80, 80); // Tamaño del panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 10, 10, 60, 60, this);
    }
}