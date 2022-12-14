import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;


import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[]args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        String lienImage = ""; //a modifier
        int iDepart=0,jDepart=0; //Demander à l'utilisateur les coordonnées de depart
        int iArrivee=0,jArrivee=0; //Demander à l'utilisateur les coordonnées d'arrivée

        System.out.println("Entrez le nom du fichier de l'image");
    	lienImage = sc.nextLine();
    	 File f = new File(lienImage);
         BufferedImage bf =ImageIO.read(f);
         
    	
    	System.out.println("Entrez la coordonnée x du point de départ entre 0 et " + bf.getWidth());
    	iDepart = sc.nextInt();
    	System.out.println("Entrez la coordonnée y du point de départ entre 0 et " + bf.getHeight());
    	jDepart = sc.nextInt();
    	System.out.println("Entrez la coordonnée x du point d'arrivée entre 0 et " + bf.getWidth());
    	iArrivee = sc.nextInt();
    	System.out.println("Entrez la coordonnée y du point d'arrivée entre 0 et " + bf.getHeight());
    	jArrivee = sc.nextInt();
       
        
        Matrice matriceImage = new Matrice(bf);
        
        Pixel depart = matriceImage.getPixel(iDepart, jDepart);
        Pixel arrivee = matriceImage.getPixel(iArrivee, jArrivee); 
    


        ArrayList<Pixel> chemin = Util.dijkstra(depart, arrivee, matriceImage);
        Util.remplirRouge(bf,chemin);
        Util.afficherImage(bf);
        sc.close();

        
    }
}
