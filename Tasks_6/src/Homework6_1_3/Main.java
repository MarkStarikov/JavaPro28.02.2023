package Homework6_1_3;

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
                for (int f = 0; f < numbers.length; f++) {
                    if (numbers[f] == target - numbers[i]){
                        return new int[]{f, i};
                    }
                }
            }
            numbersManager.add(numbers[i]);
        }
        return new int []{};
    }
}
