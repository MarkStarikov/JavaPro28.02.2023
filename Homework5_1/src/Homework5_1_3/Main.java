package Homework5_1_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Integer> numbers = new ArrayList<>(Arrays.asList( 5, 8483, 59, 32, 19, 75, 59, 43, 19, 3, 43, 3, 59, 8, 99, 8483));
         System.out.println(findUnique(numbers));
    }
        public static List <Integer> findUnique(List<Integer> numbers){
            List<Integer> clone = new ArrayList<>();
            for (Integer i: numbers){
                int count = Collections.frequency(numbers, i);
                if (count == 1) {
                    clone.add(i);
                }

            }



        return clone;
        }
}
