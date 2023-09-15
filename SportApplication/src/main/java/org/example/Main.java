package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<SportApplication> arrayList = new ArrayList<>(); // объявление списка

        SportApplication  runningFirst = new Running(10f, 130f, 60f, 80f);
        SportApplication  runningSecond = new Running( 5f, 125f, 20f, 80f);
        SportApplication crossfit = new Crossfit( 20f, 150f, 50f, 80f);
        SportApplication kickboxing = new Kickboxing( 140f, 120f, 80f);
        arrayList.add(runningSecond);
        arrayList.add(runningFirst);
        arrayList.add(crossfit);
        arrayList.add(kickboxing);

        // создаем 4 экземпляра классов и передаем в конструкторы каждого из классов параметры в ()


        for (SportApplication item: arrayList)
        {
            item.output();
        }

    }

}