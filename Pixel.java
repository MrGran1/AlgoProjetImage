import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Pixel{
    private int x,y;
    private int r,g,b;
    private Integer distance;
    private Pixel parentDijkstra;


// -------------Constructeurs ---------------------------------------------------

    public Pixel(BufferedImage bf,int x,int y){
        this.x = x;
        this.y = y;
        ArrayList<Integer> rgb = Util.getRgbFromLocation(bf, x, y);
        r =rgb.get(0);
        g =rgb.get(1);
        b =rgb.get(2);
        distance = null;
        parentDijkstra = null;
    }

    public Pixel(ArrayList<Integer> rgb){
        r =rgb.get(0);
        g =rgb.get(1);
        b =rgb.get(2);

        
    }


// ----------------- Methode -------------------------

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setDistance(int distance){
        this.distance = distance;
    }

    public Integer getDistance(){
        return distance;
    }

    public void setParentDijkstra(Pixel p){
        parentDijkstra = p;
    }

    public Pixel getParentDijkstra(){
        return parentDijkstra;
    }

    public int getR(){
        return r;
    }

    public int getG(){
        return g;
    }

    public int getB(){
        return b;
    }

    /* 
     * Cette méthode retourne la différence d'intensité entre ce pixel et un autre
     */
    public int difIntensite(Pixel p1){
        int intensite=0;
        intensite += Util.valAbs(this.r - p1.getR());
        intensite += Util.valAbs(this.g - p1.getG());
        intensite += Util.valAbs(this.b - p1.getB());
        return intensite;
    }
    /*
     * instancie l'intensité grâce à une ArrayList
     * contenant [r,g,b] où r est l'intensité de rouge dans un pixel
     * g est l'intensité de vert dans un pixel
     * b est l'intensité de bleu dans un pixel
     */
    

    

    public int getDistance(Pixel p){
        return Util.valAbs(getX()-p.getX())+Util.valAbs(getY()-p.getY());
    }


}