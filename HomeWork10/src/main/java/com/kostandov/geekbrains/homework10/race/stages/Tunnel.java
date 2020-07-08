package com.kostandov.geekbrains.homework10.race.stages;


import com.kostandov.geekbrains.homework10.race.Car;
import com.kostandov.geekbrains.homework10.race.Race;
import com.kostandov.geekbrains.homework10.race.stages.Stage;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore semaphore;

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        semaphore=new Semaphore(Race.COMPETITORS_COUNT/2);
    }

    @Override
    public void overcome(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
