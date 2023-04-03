package Homework6_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String args[]) {
        int target = 18;
        int[] numbers = new int[]{2,7,11,3,9};
        System.out.println(Arrays.toString(doubleSum( numbers, target)));
    }

    public static int [] doubleSum (int[] numbers, int target){
        Set <Integer> numbersManager = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbersManager.contains(target - numbers[i])) {
                for (int r = 0; r < numbers.length; r++) {
                    if (numbers[r] == target - numbers[i]){
                    return new int[]{r, i};
                }
            }
        }
            numbersManager.add(numbers[i]);
            }
            return new int []{};
        }
}

