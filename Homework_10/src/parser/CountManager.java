package parser;

import java.util.HashSet;
import java.util.List;

public class CountManager {
    public int uniqueCounter(List<String> words){
        return new HashSet<>(words).size();
    }
}
