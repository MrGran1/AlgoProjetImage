import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Pixel{
    private int intensite;
// -------------Constructeurs ---------------------------------------------------
    public Pixel(int r, int g, int b){
        intensite = r+b+g;
    }

    public Pixel(BufferedImage bf,int x,int y){
        setIntensite(Util.getRgbFromLocation(bf, x, y));
    }

    public Pixel(ArrayList<Integer> rgb){
        int r =rgb.get(0);
        int g =rgb.get(1);
        int b =rgb.get(2);

        intensite = r+g+b;
    }


// ----------------- Methode -------------------------
    public int getIntensite(){
        return intensite;
    }

    /* 
     * Cette méthode retourne la différence d'intensité entre ce pixel et un autre
     */
    public int difIntensite(Pixel p1){
        return Util.valAbs(intensite - p1.getIntensite());
    }
    /*
     * instancie l'intensité grâce à une ArrayList
     * contenant [r,g,b] où r est l'intensité de rouge dans un pixel
     * g est l'intensité de vert dans un pixel
     * b est l'intensité de bleu dans un pixel
     */
    
    public void setIntensite(ArrayList<Integer> rgb){
        int r =rgb.get(0);
        int g =rgb.get(1);
        int b =rgb.get(2);

        intensite = r+g+b;
    }

    /*
     * instancie l'intensité grâce à une position et un buffer
     */
    public void setIntensite(BufferedImage bf,int x,int y){
        setIntensite(Util.getRgbFromLocation(bf, x, y));
    }
}