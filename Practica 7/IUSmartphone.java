import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class IUSmartphone extends JPanel {
    private BufferedImage image;
    private Smartphone smart;

    public IUSmartphone(String nombreImagen, Smartphone smart) {
        try {
            image = ImageIO.read(new File(nombreImagen));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.smart = smart;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                // Verificar si se hizo clic dentro del área del dispositivo (ejemplo)
                if (x >= 10 && x <= 60 && y >= 10 && y <= 60) {
                    //System.out.println("Haz hecho clic en la computadora: " + computadora.getNombre());
                    System.out.println(smart.toString());
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