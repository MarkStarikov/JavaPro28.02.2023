package org.example;

public class Crossfit extends SportApplication  {
    private float maxWeight;

    public Crossfit(float maxWeight, float averagePulse, float duration, float weight) {
        super(averagePulse, duration, weight);
        this.maxWeight = maxWeight;
    }


    @Override //переопределение методов базового класса
    protected void output() {

        System.out.println ("Кроссфит тренировка! Длительность: " + duration + "минут. Средний вес штанги:" + maxWeight + "кг. Килокаллорий:"  + calorieConsumption());
    }

    @Override
    protected float calorieConsumption() {
        return 0.014f * weight * duration * (0.12f * averagePulse - 7f);
    }

}