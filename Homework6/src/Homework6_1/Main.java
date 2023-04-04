package Homework6_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> palindroms = new ArrayList<>(Arrays.asList("Madam I'm Adam", "Was it a car or a cat I saw?", "Pull up if I pull up", "Niagara roar again ", " "));
        for (int i = 0; i < palindroms.size(); i++) {
            if (isPalindrome(palindroms.get(i)))
            {
               if ((palindroms.get(i).equals(" "))) {
                   System.out.println("Phrase is an empty string \"" + palindroms.get(i) + "\" after removing non-alphanumeric characters.\n" +
                           "Since an empty string reads the same forward and backward, it is a palindrome." );
                   break;
               }
                System.out.println("Phrase \"" + palindroms.get(i) + "\" is a palindrome." );
             }
              else {
                System.out.println("Phrase \"" + palindroms.get(i) + "\" is not a palindrome." );
            }
        }

    }

    public static boolean isPalindrome(String phrase){
      phrase = phrase.replaceAll("\\W", "");
      StringBuilder palindromer = new StringBuilder(phrase);
      palindromer.reverse();
      String invertedPhrase = palindromer.toString();

      return phrase.equalsIgnoreCase(invertedPhrase);
    }
}