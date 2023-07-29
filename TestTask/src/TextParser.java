import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class TextParser {
    public List<String> readWords(String name) throws IOException {
        List<String> words;
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            words = reader.lines()
                    .flatMap(s -> Arrays.stream( s.split(" ")))
                    .map(w -> w.replace(",","").replace(".","").replace("-", ""))
                    .toList();
        }
        return words;
    }
}
