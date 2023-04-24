public class ArrayValueCalculator {

    public int doCalc(String [][] numbersAsStrings) throws ArraySizeException, ArrayDataException {

        if (numbersAsStrings.length != 4) {
            throw new ArraySizeException("Wrong array size. Try again.");
        }
        int sum = 0;
         for (int i = 0; i < numbersAsStrings.length; i++) {
            if (numbersAsStrings[i].length != 4) {
                throw new ArraySizeException("Wrong row size. Try again.");
            }
             for (int j = 0; j < numbersAsStrings[i].length; j++) {
                try {
                    sum += Integer.parseInt(numbersAsStrings[i][j]);
                } catch (NumberFormatException e){
                    throw new ArrayDataException("The given array contains non-int data. Row " + i
                            + ", column " + j);
                    /* Exercise`s point 8* System.out.println("The given array contains non-int data. Row " + i
                            + ", column " + j);*/
                }
            }
        }
        return sum;
    }

}