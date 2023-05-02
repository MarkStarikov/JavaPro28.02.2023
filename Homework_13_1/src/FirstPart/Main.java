package FirstPart;

public class Main {
    public static void main(String[] args) {
        int samplePrice [] = { 40, 35, 21,  15, 6 , 3};
        int maxYield = calculation(samplePrice);
        if (maxYield!=0)
        System.out.println("Max profit is "+ maxYield);
        else System.out.println("You didn't make any profit");
    }

    private static int calculation(int[] samplePrice) {
    int maxYield = 0;
    int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < samplePrice.length; i++) {
            if (samplePrice[i] < minPrice)
                minPrice = samplePrice[i];
            else if (samplePrice[i] - minPrice > maxYield)
                maxYield = samplePrice[i] - minPrice;
        }
        return maxYield;
    }
}