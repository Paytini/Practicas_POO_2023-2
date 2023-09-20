import java.util.ArrayList;
import java.util.Collections;

public class Monton
{
    ArrayList<FichaDomino> boneyard;
    
    public Monton(){
        boneyard = new ArrayList<>();
    }
    
    public void agregarFichaBoneyard(FichaDomino ficha){
        boneyard.add(ficha);
    }
    
    public FichaDomino agarrarFicha(){
        if(!boneyard.isEmpty()){
            return boneyard.remove(0);
        }
        else{
            return null;
        }
    }
    
    public boolean estaVacio(){
        return boneyard.isEmpty();
    }
    
    public void barajarFichas(){
        Collections.shuffle(boneyard);
    }
    
    public void verMonton(){
        for(int i = 0; i < boneyard.size(); i++){
            System.out.println("Ficha #" + i + ": " + boneyard.get(i));
        }
    }
}
