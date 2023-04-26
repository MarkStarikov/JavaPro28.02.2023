public class Main {
    public static void main(String[] args) {
        String[][] numbersAsStrings = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        ArrayValueCalculator manager = new ArrayValueCalculator();
        try {
            System.out.println(manager.check(numbersAsStrings));
            if (true){
                try {
                    System.out.println(manager.doCalc(numbersAsStrings));
                } catch (ArrayDataException  e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (ArraySizeException e) {
            System.out.println(e.getMessage());
        }



    }

}