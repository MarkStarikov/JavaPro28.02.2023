package org.example;

public class Kickboxing extends SportApplication {


    public Kickboxing(float averagePulse, float duration, float weight) {
        super(averagePulse, duration, weight);

    }


    @Override //переопределение методов базового класса
    protected void output() {

        System.out.println("Тренировка по кикбоксингу! Длительность: " + duration + "минут. Килокаллорий:" + calorieConsumption());
    }

    protected float calorieConsumption() {
        return 0.014f * weight * duration * (0.12f * averagePulse - 7f);
    }
}
