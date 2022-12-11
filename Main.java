import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[]args) throws IOException{
        String lienImage = "./image.jpg"; //a modifier
        File f = new File(lienImage);
        BufferedImage bf =ImageIO.read(f);
        Matrice matriceImage = new Matrice(bf);
        int iDepart=0,jDepart=0; //Demander à l'utilisateur les coordonnées de depart
        int iArrivee=0,jArrivee=0; //Demander à l'utilisateur les coordonnées d'arrivée
        Pixel depart = matriceImage.getPixel(iDepart, jDepart);
        Pixel arrivee = matriceImage.getPixel(iArrivee, jArrivee); 
        Stage stage = new Stage();
        
    }
}
