package org.example;

public class Running extends SportApplication {
    private final float dist1;


    public Running(float dist1, float averagePulse, float duration, float weight) {
        super(averagePulse, duration, weight);
        this.dist1 = dist1;
    }


    @Override //переопределение методов базового класса
    protected void output() {

        System.out.println ("Беговая тренировка! Длительность: " + duration + "минут. Дистанция:" + dist1 + "км. Килокаллорий:" + calorieConsumption());
    }

    protected float calorieConsumption() {
        return 0.014f * weight * duration * (0.12f * averagePulse - 7f); // метод возвращает результат формулы

    }

}
