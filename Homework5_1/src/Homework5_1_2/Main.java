package Homework5_1_2;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
     String [] chemicalElements = new String[] {"Sodium", "Iron", "Oxygen", "Lead", "Neon", "Tin", "Nickel", "Zinc", "Gold", "Silver", "Copper", "Uranus", "Carbon", "Nitrogen"};
        for (int i = 0; i < chemicalElements.length; i++) {
            System.out.println(chemicalElements[i]);
        }
         List<String> elements = toList(chemicalElements);
        System.out.println(elements);
    }
    public static <String> List<String> toList(String[] chemical){
        List<String> elements = new ArrayList<>();
        for (String i: chemical){
            elements.add(i);
        }
        return elements;
    }
}
