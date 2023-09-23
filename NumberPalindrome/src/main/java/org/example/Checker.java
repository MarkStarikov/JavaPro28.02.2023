package org.example;

public class Checker {
    public boolean isPallindrome (int i){
        if (i < 0){
            return false;
        }
        if (i % 10 == 0 && i != 0){
            return false;
        }
        int invertNumber = 0;
        int copyOfI = i;
        while (copyOfI != 0){
            invertNumber = invertNumber * 10 + copyOfI % 10;
            copyOfI = copyOfI / 10;
        }
        return invertNumber == i;
    }
}
