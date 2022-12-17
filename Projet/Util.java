import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

public  class Util {

    /*
     * retourne la valeur absolu d'un int a
     */
    public static int valAbs(int a){
        if (a>=0){
            return a;
        }
        else {
            return -a;
        }
    }

    public static ArrayList<Integer> getRgb(int p){
        ArrayList<Integer> rgb = new ArrayList<>();
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b =  0xff;

        rgb.add(r);
        rgb.add(g);
        rgb.add(b);
        return rgb;
    }

    public static ArrayList<Integer> getRgbFromLocation(BufferedImage bf,int x,int y){
        ArrayList<Integer> rgb = new ArrayList<>();

        int p = bf.getRGB(x,y);

        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b =  0xff;

        rgb.add(r);
        rgb.add(g);
        rgb.add(b);
        return rgb;
    }
    
    //retourne le poids de l'arête entre deux pixels
    public static int poids(Pixel p1,Pixel p2){
        return p1.difIntensite(p2);
    }

    //fonction qui fait un algorithme de dijkstra entre deux points en fonction de l'intensité des pixels
   
    public static ArrayList<Pixel> dijkstra(Pixel depart, Pixel arrivee, Matrice matriceImage){
        
        ArrayList<Pixel> chemin = new ArrayList<>();
        
        ArrayList<Pixel> pixelsNonVisites = new ArrayList<>();

        Pixel pixelActu = depart;
        depart.setDistance(0);
        while(pixelActu != arrivee){
            
           for(Pixel voisin : matriceImage.getVoisin(pixelActu)){ // On défini la valeur des distances des voisins
            
                Integer distance = pixelActu.getDistance() + voisin.difIntensite(pixelActu)+1;
                
                if (voisin.getDistance()==null){
                    voisin.setDistance(distance);
                    voisin.setParentDijkstra(pixelActu);
                    pixelsNonVisites.add(voisin);
                   
                }
                else if(voisin.getDistance()>distance){
                    voisin.setParentDijkstra(pixelActu);
                    voisin.setDistance(distance);
                }

           }
          
           Pixel pixelMin = pixelsNonVisites.get(0);
           for (int i =1;i<pixelsNonVisites.size();i++){
                if (pixelsNonVisites.get(i).getDistance()< pixelMin.getDistance()){
                    pixelMin = pixelsNonVisites.get(i);
                }
           }
           pixelsNonVisites.remove(pixelMin);
           pixelActu = pixelMin;
           




        }
        
        while(!pixelActu.equals(depart)){
            
            chemin.add(pixelActu);
            pixelActu = pixelActu.getParentDijkstra();
        }

        return chemin;
    }


    public static void remplirRouge(BufferedImage bf, ArrayList<Pixel> chemin){
        for (Pixel p : chemin){
            bf.setRGB(p.getX(),p.getY(),0xff0000);
        }
    }
    
    public static void afficherImage(BufferedImage bf){
    	ImageIcon image = new ImageIcon(bf);
        JFrame fenetre = new JFrame();
      //  JPanel pane = new JPanel();
        JLabel j = new JLabel ();
        j.setIcon(image);
        fenetre.add(j);
        
       // fenetre.setContentPane(pane);
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public static void demanderCoordonnee() {
    	JFrame fenetre = new JFrame();
    	JTextField x = new JTextField ("Coordonnée de x de départ");
    	JTextField y = new JTextField ("Coordonnée de y de départ");

    	JTextField xFin = new JTextField ("Coordonnée de x de fin");
    	JTextField yFin = new JTextField ("Coordonnée de y de fin");

    	fenetre.add(x);
    	fenetre.add(y);
    	fenetre.add(xFin);
    	fenetre.add(yFin);
    	Button b = new Button("ok");
    	fenetre.add(b);
    }
}
    	
    	

