public class Pixel{
    private int intensite;

    public Pixel(int r, int g, int b){
        intensite = r+b+g;
    }

    public int getIntensite(){
        return intensite;
    }

    public int difIntensite(Pixel p1){
        return Util.valAbs(intensite - p1.getIntensite());
    }
}