package Homework5_1_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> vitamins = new ArrayList<>(Arrays.asList("A", "C", "E", "B12", "K", "B5", "D", "B9", "C", "P", "E", "D", "B5", "D", "B9", "C", "P", "A", "B12", "P", "B9", "B5", "P", "E"));
        findOccurance(vitamins);
        System.out.println(findOccurance(vitamins));
    }
    static public List<String> findOccurance(List<String> vitamins) {
        List<String> vitaminesOccurabce = new ArrayList<>();
        for (String i : vitamins) {
            int count = Collections.frequency(vitamins, i);
            if (vitaminesOccurabce.contains("\n {name: \"" + i + "\" occurrence: " + count + "}")) {

            } else {
                vitaminesOccurabce.add("\n {name: \"" + i + "\" occurrence: " + count + "}");
            }
            }
        return vitaminesOccurabce;
    }
}

