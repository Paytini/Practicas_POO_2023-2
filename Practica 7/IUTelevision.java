import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

class IUTelevision extends JPanel {
    private BufferedImage image;
    private Television television;

    public IUTelevision(String nombreImagen, Television television) {
        try {
            image = ImageIO.read(new File(nombreImagen)); // Se le la imagen.png
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.television = television;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                // Verificar si se hizo clic dentro del área del dispositivo (ejemplo)
                if (x >= 10 && x <= 60 && y >= 10 && y <= 60) {
                    //System.out.println("Haz hecho clic en la televisión: " + television.getNombre());
                    System.out.println(television.toString());
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
