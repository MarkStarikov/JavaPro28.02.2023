package SecondPart;

public class Rivers {
    String name;
    int length;
    int catchmentArea;

    public Rivers(String name, int length, int catchmentArea) {
        this.name = name;
        this.length = length;
        this.catchmentArea = catchmentArea;
    }

    @Override
    public String toString() {
        return "{" +
                " name = '" + name + '\'' +
                ", length=" + length +
                " km, catchmentArea = " + catchmentArea +
                " square km"+
                '}';
    }
}
