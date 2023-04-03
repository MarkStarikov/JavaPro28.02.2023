package Homework5_1_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> vitamins = new ArrayList<>(Arrays.asList("A", "C", "E", "D", "B12", "K", "B5", "D", "B9", "C", "P", "E",  "B5", "D", "B9", "C", "P", "A", "B12", "P", "B9", "B5", "P", "E"));
        calcOccurance(vitamins);
    }
    static public void calcOccurance(List<String> vitamins) {
        List<String> cloneUnique = new ArrayList<>();
        for (String i: vitamins){
            int count = Collections.frequency(vitamins, i);
            if (cloneUnique.contains(i)) {
                continue;
            } else {
                cloneUnique.add(i);
            }
            System.out.println("Vitamin "+ i + ": " + count);
        }
       }
    }


