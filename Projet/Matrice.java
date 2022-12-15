import java.util.ArrayList;
import java.awt.image.BufferedImage;

/*
 * Cette classe représente une matrice de pixels
 * 
 */
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

    /*
     * Cette méthode retourne une ArrayList de voisin du pixel
     */
    public ArrayList<Pixel> getVoisin(Pixel p){
        ArrayList<Pixel> voisin = new ArrayList<>();
        int x = p.getX();
        int y = p.getY();
        
        if (x>0){
            voisin.add(this.get(x-1).get(y));
        }
        if (x<this.size()-1){
            voisin.add(this.get(x+1).get(y));
        }
        if (y>0){
            voisin.add(this.get(x).get(y-1));
        }
        if (y<this.get(0).size()-1){
            voisin.add(this.get(x).get(y+1));
        }
        return voisin;
    }

    public Pixel getPixel(int x,int y){
        return this.get(x).get(y);
    }
}
