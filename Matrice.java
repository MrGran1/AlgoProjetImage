import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Matrice extends ArrayList<ArrayList<Pixel>>{
    public Matrice (BufferedImage bf){
        int x= bf.getWidth();
        int y = bf.getHeight();
        for (int i = 0; i < x; i++) {
            ArrayList<Pixel> ligne = new ArrayList<>();
            for (int j = 0; j < y; j++) {
                ligne.add(new Pixel(bf,i,j));
            }
            this.add(ligne);
        }
    }
    
}
