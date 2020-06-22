package com.kostandov.geekbrains.homework3.obstacles;



public class Treadmill implements MarathonObstacle {
    private final int length;

    public int getLength() {
        return length;
    }

    public Treadmill(int length){
        this.length = length;
    }
}
