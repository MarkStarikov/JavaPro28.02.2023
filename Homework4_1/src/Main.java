public class Main {

        public static void main(String[] args) {

            Areable[] array = new Areable[3];
            array [0] = new Circle();
            array [1] = new Rectangle();
            array [2] = new Square();
            System.out.println("Sum of the all massive`s geometric figures is "+Main.calcSum(array)+ " sm");

        }

    private static double calcSum(Areable[] array) {

          double sum = array [0].calcAreaFigure() + array [1].calcAreaFigure() +array [2].calcAreaFigure(); //А что, так можно было????
          return sum;
    }
}