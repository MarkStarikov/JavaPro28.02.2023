package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GoodPairSearcher {
    public int goodPairIdentification (int [] numbers){
        Map<Integer, List<Integer>> base = new HashMap<>();
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(base.get(numbers[i]) == null){
                List <Integer> container = new LinkedList<>();
                container.add(numbers[i]);
                base.put(numbers[i], container);
            } else {
                List <Integer> container = base.get(numbers[i]);
                count += container.size();
                container.add(numbers[i]);
                base.put(numbers[i], container);
            }
        }
        return count;
    }
}
