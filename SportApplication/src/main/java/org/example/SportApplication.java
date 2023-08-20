package org.example;

public abstract class SportApplication {

    protected float averagePulse;
    protected float duration;
    protected float weight;

    public SportApplication(float averagePulse, float duration, float weight) {
        this.averagePulse = averagePulse;
        this.duration = duration;
        this.weight = weight;
    }

    //переопределение методов базового класса
    protected abstract void output();

    protected abstract float calorieConsumption();

    //переопределение методов базового класса

}
