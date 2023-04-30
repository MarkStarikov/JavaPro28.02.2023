package parser;

import java.io.FileWriter;
import java.io.IOException;

public class Registrar {
    public void saveStatistic(String... words) throws IOException {
        try(FileWriter writer = new FileWriter("statistic.txt")) {
            for (String word : words) {
                writer.write(word);
            }
        }
    }
}
