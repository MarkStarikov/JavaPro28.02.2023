import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static final String DIRECTORY = "src/";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextParser convertor = new TextParser();
        System.out.print("Insert name of book, please");
        String bookName = scanner.nextLine();
        List<String> words;
        try {
            words = convertor.readWords(DIRECTORY + bookName + ".txt");
        } catch (IOException e) {
            throw new NotFoundItemException("Incorrect file name. Please, check and try again");
        }
        System.out.println(findFirstUniqueChar(words));
        scanner.close();
    }
    public static Character findFirstUniqueChar (List<String> words) throws NotFoundItemException{
        List<Character> unique = new ArrayList<>();
        for (String word : words) {
            for (int f = 0; f < word.length(); f++) {
                /*boolean firstUnique = false;*/
                for (int s = 0; s < word.length(); s++) {
                    if(f != s && word.charAt(f) == word.charAt(s)){
                        break;
                    }
                }
                /*if (!firstUnique){*/
                unique.add(word.charAt(f));
                break;
                /*}*/
            }
        }
        if (unique.isEmpty()){
            throw new NotFoundItemException("Provided text has words with repeat symbols only");
        } else {
            return unique.stream()
                    .filter(character -> Collections.frequency(unique, character) < 2)
                    .findFirst()
                    .orElseThrow(() -> new NotFoundItemException("This list has not unique symbol"));
        }
    }
}