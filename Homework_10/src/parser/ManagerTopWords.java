package parser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerTopWords {
    public Map<String, Long> tenMostFrequentWords(List<String> words){
        return words.stream()
                .collect(Collectors.groupingBy(word-> word, Collectors.counting()))
                .entrySet().stream()
                .sorted((l,r)-> Math.toIntExact(r.getValue() - l.getValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
