public class Main {
    public static void main(String[] args) {
        String[][] numbersAsStrings = {
                {"1","r", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        ArrayValueCalculator manager = new ArrayValueCalculator();
        try {
            System.out.println(manager.doCalc(numbersAsStrings));
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println(e.getMessage());
        }


    }

}