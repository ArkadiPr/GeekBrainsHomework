package com.kostandov.geekbrains.homework19.main;

import com.kostandov.geekbrains.homework19.data.PrepareData;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PrepareData.forcePrepareData();
        System.out.println(optimisticLock());
        //System.out.println(pessimisticLock());
    }

    public static Long pessimisticLock(){
        CountDownLatch countDownLatch=new CountDownLatch(8);
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        long time=System.currentTimeMillis();
        for(int i=0;i<8;i++){
            executorService.execute(new UserThreadPessimisticLock(countDownLatch,(long)i+1));
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis()-time;

    }


    public static Long optimisticLock(){
        CountDownLatch countDownLatch=new CountDownLatch(8);
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        long time=System.currentTimeMillis();
        for(int i=0;i<8;i++){
            executorService.execute(new UserThreadOptimisticLock(countDownLatch,(long)i+1));
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis()-time;
    }
}
