public class Square implements Areable {

    private int side = 8;

    @Override
    public double calcAreaFigure() {

        int areaSquare = side * side;
        return areaSquare;
    }
}
