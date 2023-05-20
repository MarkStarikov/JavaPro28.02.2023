package org.example;

import java.util.HashSet;
import java.util.Set;

public class Jeweler {
    public int numJewelsIsInStones (String  jewels, String stones)  {
        if (jewels == null||stones == null) {
           return -1;
        }else {
            Set<Character> jewelsCollection = new HashSet<>();
            for (char unit : jewels.toCharArray()) {
                jewelsCollection.add(unit);
            }
            int count = 0;
            for (char unit : stones.toCharArray()) {
                if (jewelsCollection.contains(unit))
                    count++;

            }
            return count;
        }
    }
}
