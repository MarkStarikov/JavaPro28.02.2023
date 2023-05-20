package org.example;

public class BalloonSearcher {
    public int maxQuantityOfBalloons(String statement) {
        if (statement == null) {
            return -1;
        } else {
            int b = 0, a = 0, l = 0, o = 0, n = 0;
            for (char character : statement.toCharArray()) {
                switch (character) {
                    case 'b' -> b++;
                    case 'a' -> a++;
                    case 'l' -> l++;
                    case 'o' -> o++;
                    case 'n' -> n++;
                }
            }
            return Math.min(Math.min(o / 2, l / 2), Math.min(Math.min(b, a), n));
        }
    }
}