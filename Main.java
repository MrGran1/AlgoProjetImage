import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[]args) throws IOException{
        String lienImage = "./image.jpg"; //a modifier
        File f = new File(lienImage);
        BufferedImage bf =ImageIO.read(f);
        
        System.out.println(Util.getRgbFromLocation(bf, 20, 40));
        //comment obtenir les couleurs
         
    }
}
