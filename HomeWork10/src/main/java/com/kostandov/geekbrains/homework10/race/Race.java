package com.kostandov.geekbrains.homework10.race;

import com.kostandov.geekbrains.homework10.race.stages.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Race {
    public static final int COMPETITORS_COUNT = 4;
    private CyclicBarrier prepareBarrier=new CyclicBarrier(COMPETITORS_COUNT);
    private CountDownLatch raceStartCount=new CountDownLatch(COMPETITORS_COUNT);
    private CountDownLatch raceEndCount=new CountDownLatch(COMPETITORS_COUNT);

    private List<Stage> stages;

    public List<Stage> getStages() { return stages; }

    public Race(Stage... stages) {
        this.stages = new ArrayList(Arrays.asList(stages));
    }

    public void begin() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Car[] cars = new Car[COMPETITORS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10),prepareBarrier,raceStartCount,raceEndCount);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            raceStartCount.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            raceEndCount.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
