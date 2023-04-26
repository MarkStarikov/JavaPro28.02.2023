public class ArrayValueCalculator {
    public boolean check(String [][] numbersAsStrings)throws ArraySizeException{
        if (numbersAsStrings.length != 4) {
            throw new ArraySizeException("Given array size has " +numbersAsStrings.length + " rows. Please enter an array with 4 rows.");
        }
        for (int k = 0; k < numbersAsStrings.length; k++) {
            if (numbersAsStrings[k].length != 4) {
                throw new ArraySizeException("Row with index " + k + " has " + numbersAsStrings[k].length +" cells. All rows must have 4 cells");
            }
        }
        return true;
    }
    public int doCalc(String [][] numbersAsStrings) throws ArrayDataException {
        int sum = 0;
         for (int i = 0; i < numbersAsStrings.length; i++) {
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