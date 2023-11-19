import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
/**
 * Write a description of class AppDemoHerencia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AppDemoHerencia
{
    public static void main(String args[]){
        Smartphone smartphone1 = new Smartphone("Samsung", "1234", "Galaxy S20", "Smartphone1", 799.99f, 
            new Sensor("SensorCo", "5678", "ModeloX", "SensorHuella","Tipo1", "cm", 30), 
            new Pantalla("Samsung", "1234", "Galaxy S20", "Pantalla1", null, 1920, 1080));

        Smartphone smartphone2 = new Smartphone("Apple", "5678", "iPhone 13", "Smartphone2", 999.99f, 
            new Sensor("Apple", "91011", "ModeloY", "SensorHuella","Tipo2", "mm", 40), 
            new Pantalla("Apple", "5678", "iPhone 13", "Pantalla2", null, 2532, 1170));

        Television tv1 = new Television("Sony", "1111", "Bravia", "TV1", 1299.99f, 
            new Pantalla("Sony", "1111", "Bravia", "TV1", null, 3840, 2160));

        Television tv2 = new Television("LG", "2222", "OLED", "TV2", 1799.99f, 
            new Pantalla("LG", "2222", "OLED", "TV2", null, 3840, 2160));

        // Crear listas
        ArrayList<Smartphone> listaDeSmartphones = new ArrayList<>();
        listaDeSmartphones.add(smartphone1);
        listaDeSmartphones.add(smartphone2);

        ArrayList<Television> listaDeTVs = new ArrayList<>();
        listaDeTVs.add(tv1);
        listaDeTVs.add(tv2);

        // Desplegar atributos de los Smartphones
        System.out.println("Atributos de Smartphones:");
        for (Smartphone smartphone : listaDeSmartphones) {
            System.out.println(smartphone.toString());
        }

        // Desplegar atributos de los Televisores
        System.out.println("\nAtributos de Televisores:");
        for (Television television : listaDeTVs) {
            System.out.println(television.toString());
        }
        /*
        // Crear una computadora, un smartphone y una televisión y mostrarlos en el jframe
        SwingUtilities.invokeLater(() -> {
            Computadora computadora = new Computadora("FabricanteComp", "12345", "MarcaComp", "Computadora", 1200, new Microprocesador("Intel", "12345", "Intel Corp", "Procesador1", 8192, 3500000000L), 8);
            IUComputadora iuC1 = new IUComputadora("compu.png", computadora);
        
            Television tv1 = new Television("Sony", "1111", "Bravia", "TV1", 1299.99f, new Pantalla("Sony", "1111", "Bravia", "TV1", 3840, 2160));
            IUTelevision tele = new IUTelevision("tele.png", tv1);
            
            Smartphone smartphone1 = new Smartphone("Samsung", "1234", "Galaxy S20", "Smartphone1", 799.99f, new Sensor("SensorCo", "5678", "ModeloX", "SensorHuella","Tipo1", "cm", 30), new Pantalla("Samsung", "1234", "Galaxy S20", "Pantalla1", 1920, 1080));
            IUSmartphone smartphone = new IUSmartphone("smart.png", smartphone1);
            
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLayout(new FlowLayout());
            frame.add(iuC1);
            frame.add(tele);
            frame.add(smartphone);
            frame.setVisible(true);
        });   */ 
    }
}
