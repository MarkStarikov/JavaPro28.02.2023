public class Rectangle implements Areable{

    private int width = 6;
    private int lenght  = 7;


    @Override
    public double calcAreaFigure() {
        int areaRectangle = lenght  * width ;
        return areaRectangle;
    }


}
