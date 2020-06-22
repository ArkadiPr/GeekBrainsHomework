package com.kostandov.geekbrains.homework3.obstacles;

public class Wall implements MarathonObstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
