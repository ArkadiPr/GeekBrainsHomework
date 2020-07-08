package com.kostandov.geekbrains.homework10.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier prepareBarrier;
    private CountDownLatch raceStartCount;
    private CountDownLatch raceEndCount;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed,CyclicBarrier prepareBarrier,CountDownLatch raceStartCount,CountDownLatch raceEndCount) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.prepareBarrier=prepareBarrier;
        this.raceStartCount=raceStartCount;
        this.raceEndCount=raceEndCount;
    }


    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            prepareBarrier.await();
            raceStartCount.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).overcome(this);
        }
        raceEndCount.countDown();
        synchronized(this){
            if (raceEndCount.getCount() == CARS_COUNT-1) {
                System.out.println(this.name + "Победил в Гонке!!!!!!!!");
            }
        }
    }
}