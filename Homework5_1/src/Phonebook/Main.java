package Phonebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /* List<PhoneDirectory> myPhonebook = new ArrayList<>(Arrays.asList());*/
        PhoneDirectory myDirectory = new PhoneDirectory();
        myDirectory.addRecords(new Record("Petrenko", "093"));
        myDirectory.addRecords(new Record("Sidorenko", "073"));
        myDirectory.addRecords(new Record("Vasilenko", "096"));
        myDirectory.addRecords(new Record("Stepanenko", "050"));
        myDirectory.addRecords(new Record("Petrenko", "063"));

        System.out.println(myDirectory.findAll("Petrenko"));
        System.out.println(myDirectory.findRecord("Stepanenko"));
    }
}
