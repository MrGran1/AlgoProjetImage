import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.rmi.CORBA.Util;

import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[]args) throws IOException{
        
        String lienImage = "./image.jpg"; //a modifier
        File f = new File(lienImage);
        BufferedImage bfDepart =ImageIO.read(f);

        File fFin = new File("./image.jpg");
        BufferedImage bfFin =ImageIO.read(fFin);


        Matrice matriceImage = new Matrice(bfDepart);
        int iDepart=0,jDepart=0; //Demander à l'utilisateur les coordonnées de depart
        int iArrivee=20,jArrivee=40; //Demander à l'utilisateur les coordonnées d'arrivée
        Pixel depart = matriceImage.getPixel(iDepart, jDepart);
        Pixel arrivee = matriceImage.getPixel(iArrivee, jArrivee); 
    


        ArrayList<Pixel> chemin = Util.dijkstra(depart, arrivee, matriceImage);
        Util.remplirRouge(bfFin,chemin);
        afficherImage(bfFin);

        
    }
}
