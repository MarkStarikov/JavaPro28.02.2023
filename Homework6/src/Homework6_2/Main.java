package Homework6_2;

import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String args[]) {
        int[] randomNumbers = new int[]{75, 99, 5, 8, 8483, 59, 32, 19, 75, 59, 43, 19, 3, 43, 3, 59, 5, 8, 99, 8483, 32};
        System.out.println(findDuplicate(randomNumbers));

    }

    public static boolean findDuplicate(int[] randomNumbers) {
        HashMap<Integer, Integer> searcher = new HashMap<>();
        for (int element : randomNumbers) {
            Object value = searcher.get(element);
            if (value == null)
                value = 0;
            searcher.put(element, (int) value + 1);

        }
        for (Map.Entry mapNumber : searcher.entrySet()) {
            int value = (int) mapNumber.getValue();
            if (value == 1) {
                return false;
            }
        }
        return true;
    }
}