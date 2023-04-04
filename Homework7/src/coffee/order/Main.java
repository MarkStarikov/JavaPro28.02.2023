package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard sunday = new CoffeeOrderBoard();
        sunday.add("Pavlo");
        sunday.add("Mark");
        sunday.add("Fedir");
        sunday.add("Petro");
        sunday.add("Mark");
        sunday.add("Ivan");
        sunday.draw();
        System.out.println("___________________________");
        System.out.println(sunday.deliver(2));
        System.out.println("___________________________");
        System.out.println(sunday.deliver());


    }
}