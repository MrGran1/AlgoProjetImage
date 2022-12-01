import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[]args) throws IOException{
        String lienImage = "./image.jpg"; //a modifier
        File f = new File(lienImage);
        BufferedImage bf =ImageIO.read(f);
        Matrice matrice = new Matrice(bf);
        System.out.println(matrice);
         
    }
}
