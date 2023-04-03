package Homework6_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> pallindroms = new ArrayList<>(Arrays.asList("Madam I'm Adam", "Was it a car or a cat I saw?", "Pull up if I pull up", "Niagara roar again ", " "));
        for (int i = 0; i < pallindroms.size(); i++) {
            if (isPalindrome(pallindroms.get(i)))
            {
               if ((pallindroms.get(i).equals(" "))) {
                   System.out.println("Phrase is an empty string \"" + pallindroms.get(i) + "\" after removing non-alphanumeric characters.\n" +
                           "Since an empty string reads the same forward and backward, it is a palindrome." );
                   break;
               }
                System.out.println("Phrase \"" + pallindroms.get(i) + "\" is a palindrome." );
             }
              else {
                System.out.println("Phrase \"" + pallindroms.get(i) + "\" is not a palindrome." );
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