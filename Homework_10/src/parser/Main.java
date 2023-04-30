package parser;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static final String DIRECTORY = "src/parser/";
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BookParser convertor = new BookParser();
        ManagerTopWords controller = new ManagerTopWords();
        Registrar accountant = new Registrar();
        CountManager supervisor = new CountManager();
        System.out.print("Insert name of book, please");
        String bookName = scanner.nextLine();
        List<String> words;
        try {
           words = convertor.readWords(DIRECTORY + bookName + ".txt");
        } catch (IOException e) {
            System.out.println("Incorrect file name. Please, check and try again");
            return;
        }
        Map<String, Long> topWords = controller.tenMostFrequentWords(words);
        Integer unique = supervisor.uniqueCounter(words);
        System.out.println(topWords);
        System.out.println(supervisor.uniqueCounter(words));
        try {
            accountant.saveStatistic(topWords.toString(),"\n Unique words" + unique);
        } catch (IOException e) {
            System.out.println(" Cannot save file.");
        }
        scanner.close();
    }
}