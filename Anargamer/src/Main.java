import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        String word1 = "signal";
        String word2 = "glanis";
        if (counter.anagramCounting (word1, word2) == true)
        System.out.println( word1 + " является анаграмой "+ word2);
        else   System.out.println( word1 + " не является анаграмой "+ word2);
    }

}