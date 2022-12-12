import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Pixel{
    private int x,y;
    private int intensite;
    private Integer distance;
    private Pixel parentDijkstra;


// -------------Constructeurs ---------------------------------------------------

    public Pixel(BufferedImage bf,int x,int y){
        this.x = x;
        this.y = y;
        ArrayList<Integer> rgb = Util.getRgbFromLocation(bf, x, y);
        intensite = rgb.get(0)+rgb.get(1)+rgb.get(2);
        distance = null;
        parentDijkstra = null;
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

    public int getDistance(Pixel p){
        return Util.valAbs(getX()-p.getX())+Util.valAbs(getY()-p.getY());
    }

    public void setPrecedent(Pixel p){
        //TODO
        
    }

    public String toString(){
        return "("+x+" : "+y+") intensite : "+intensite;
    }

}