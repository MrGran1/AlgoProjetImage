import java.util.ArrayList;
import java.awt.image.BufferedImage;

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
        ArrayList<Pixel> pixelsVisites = new ArrayList<>();
        ArrayList<Pixel> pixelsNonVisites = new ArrayList<>();

        Pixel pixelActu = depart;
        while(pixelActu != arrivee){
            pixelsVisites.add(pixelActu);
            ArrayList<Pixel> voisins = matriceImage.getVoisins(pixelActu);
            for(Pixel p : voisins){
                if(!pixelsVisites.contains(p)){
                    if(p.getDistance() == null){
                        p.setDistance(Util.poids(pixelActu, p));
                        p.setParentDijkstra(pixelActu);
                    }
                    else if(p.getDistance() > Util.poids(pixelActu, p) + pixelActu.getDistance()){
                        p.setDistance(Util.poids(pixelActu, p) + pixelActu.getDistance());
                        p.setParentDijkstra(pixelActu);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(Pixel p : voisins){
                if(!pixelsVisites.contains(p)){
                    if(p.getDistance() < min){
                        min = p.getDistance();
                        pixelActu = p;
                    }
                }
            }
        }
        










        return null;
    }


    public static void remplirRouge(BufferedImage bf, ArrayList<Pixel> chemin){
        for (Pixel p : chemin){
            bf.setRGB(p.getX(),p.getY(),0xff0000);
        }
    }
    
    public void afficherImage(BufferedImage bf){
        Stage stage = new Stage();
        stage.setTitle("Image");
        stage.setScene(new Scene(new HBox(new ImageView(SwingFXUtils.toFXImage(bf, null)))));
        stage.show();
    }


}

