package com.kostandov.geekbrains.homework10.race.stages;


import com.kostandov.geekbrains.homework10.race.Car;

public abstract class Stage {
    int length;
    String description;

    public String getDescription() {
        return description;
    }

    public abstract void overcome(Car c);
}
