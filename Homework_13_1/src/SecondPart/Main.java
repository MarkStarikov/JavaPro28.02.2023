package SecondPart;
public class Main {
    public static void main(String[] args) {
       Convertor<Rivers> biggestRivers = new Convertor<>();
       biggestRivers.add(new Rivers ("Nile", 6650, 3254555));
       biggestRivers.add(new Rivers ("Amazon", 6575, 7050000));
       biggestRivers.add(new Rivers ("Yangtze", 6300, 1800000));
       biggestRivers.add(new Rivers ("Mississippi", 6275, 2980000));
       biggestRivers.add(new Rivers ("Yellow", 6564, 745000));
       biggestRivers.add(new Rivers ("Parana", 4800, 2582672));
       biggestRivers.add(new Rivers ("Congo", 4700, 3680000));
       biggestRivers.add(new Rivers ("Amur", 4480, 1855000));

        for (Rivers watercourse : biggestRivers) {
            System.out.println(watercourse);
        }
        biggestRivers.reverseRivers();
        System.out.println("_____________________________________________________________________");

        for (Rivers watercourse : biggestRivers) {
            System.out.println(watercourse);
        }
    }
}
