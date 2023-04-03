package Homework5_1_1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String randomCity = "Brno";
        List<String> cities = new ArrayList<>(Arrays.asList("Olomouc", "Lodz,", "Brno", "Ploesti", "Varna", "Brno", "Trnava", "Kluzh", "Lodz", "Rzheshuv", "Brashov", "Brno", "Mishkolts", "Brailov", "Kishvarda", "Chelm", "Kluzh", "klodzko", "Belostok", "Ostrava", "Gdunya"));
        countOccurrence(cities, randomCity);
        System.out.println("Quantity of repeat city Brno are " + countOccurrence(cities, randomCity));
    }

    static int countOccurrence(List<String> cities, String randomCity) {
        int b = 0;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).equals("Brno")) {
                b++;

            }
        }
        return b;
    }
}