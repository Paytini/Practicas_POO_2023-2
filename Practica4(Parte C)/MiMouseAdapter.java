import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author molguin
 *
 * Agregar la siguiente linea de codigo en el constructor
 * de la clase Canvas:
 * canvas.addMouseListener(new MiMouseAdapter(this));
 *
 */
public class MiMouseAdapter extends MouseAdapter {
    
    Canvas canvas;
    public String letraTeclada;
    private int acum = 1;
    private int j = 60;
    private int clicks = 0;    
    public MiMouseAdapter(Canvas canvas) {
       super();
       this.canvas = canvas;
    }
        
    @Override
     public void mousePressed(MouseEvent e) {
          int x = e.getX();
          int y = e.getY();
          int i = 0;
          int z = 60;
          letraTeclada = null;
          System.out.println("hola");
          if((x >= 70 && x <= 85) && (y >= 500 && y <= 520)){
              letraTeclada = "A";
          }
          if((x >= 95 && x <= 110) && (y >= 500 && y <= 520)){
              letraTeclada = "B";
          }
          if((x >= 120 && x <= 135) && (y >= 500 && y <= 520)){
              letraTeclada = "C";
          }
          if((x >= 145 && x <= 160) && (y >= 500 && y <= 520)){
              letraTeclada = "D";
          }
          if((x >= 170 && x <= 185) && (y >= 500 && y <= 520)){
              letraTeclada = "E";
          }
          if((x >= 195 && x <= 210) && (y >= 500 && y <= 520)){
              letraTeclada = "F";
          }
          if((x >= 220 && x <= 235) && (y >= 500 && y <= 520)){
              letraTeclada = "G";
          }
          if((x >= 245 && x <= 260) && (y >= 500 && y <= 520)){
              letraTeclada = "H";
          }
          if((x >= 270 && x <= 285) && (y >= 500 && y <= 520)){
              letraTeclada = "I";
          }
          if((x >= 295 && x <= 310) && (y >= 500 && y <= 520)){
              letraTeclada = "J";
          }
          if((x >= 85 && x <= 100) && (y >= 548 && y <= 570)){
              letraTeclada = "K";
          }
          if((x >= 110 && x <= 125) && (y >= 548 && y <= 570)){
              letraTeclada = "L";
          }
          if((x >= 135 && x <= 150) && (y >= 548 && y <= 570)){
              letraTeclada = "M";
          }
          if((x >= 160 && x <= 175) && (y >= 548 && y <= 570)){
              letraTeclada = "N";
          }
          if((x >= 185 && x <= 200) && (y >= 548 && y <= 570)){
              letraTeclada = "O";
          }
          if((x >= 210 && x <= 225) && (y >= 548 && y <= 570)){
              letraTeclada = "P";
          }
          if((x >= 235 && x <= 250) && (y >= 548 && y <= 570)){
              letraTeclada = "Q";
          }
          if((x >= 260 && x <= 275) && (y >= 548 && y <= 570)){
              letraTeclada = "R";
          }
          if((x >= 285 && x <= 300) && (y >= 548 && y <= 570)){
              letraTeclada = "S";
          }
          if((x >= 110 && x <= 125) && (y >= 600 && y <= 620)){
              letraTeclada = "T";
          }
          if((x >= 135 && x <= 150) && (y >= 600 && y <= 620)){
              letraTeclada = "U";
          }
          if((x >= 160 && x <= 175) && (y >= 600 && y <= 620)){
              letraTeclada = "V";
          }
          if((x >= 185 && x <= 200) && (y >= 600 && y <= 620)){
              letraTeclada = "W";
          }
          if((x >= 210 && x <= 225) && (y >= 600 && y <= 620)){
              letraTeclada = "X";
          }
          if((x >= 235 && x <= 250) && (y >= 600 && y <= 620)){
              letraTeclada = "Y";
          }
          if((x >= 260 && x <= 275) && (y >= 600 && y <= 620)){
              letraTeclada = "Z";
          }
          
          if(letraTeclada != null){
              canvas.drawString(letraTeclada, j+3, (z*acum)+16);
              j = j + 60;
              System.out.println("Clic número: " + acum + ", letra: " + letraTeclada);
              clicks++;
               // Aumentar acum solo después de 5 clics
              if (clicks % 5 == 0) {
                  j = 60;
                  acum++;
              }
          }else{
              System.out.println("No se tecleó ninguna letra válida.");
          }
          //System.out.println("Mouse clicked at (" + x + ", " + y + ")");
          //this.canvas.drawString("Hola", x, y);
     }
}