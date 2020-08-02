package com.kostandov.geekbrains.homework19.main;

import com.kostandov.geekbrains.homework19.entitys.Lot;
import com.kostandov.geekbrains.homework19.entitys.User;
import com.kostandov.geekbrains.homework19.hibernate.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.OptimisticLockException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class UserThreadOptimisticLock implements Runnable {
    CountDownLatch countDownLatch;
    Long user_id;
    Session session;

    public UserThreadOptimisticLock(CountDownLatch countDownLatch, Long user_id) {
        this.countDownLatch = countDownLatch;
        this.user_id = user_id;
        session=null;
    }

    @Override
    public void run() {
        session = HibernateUtil.getSessionFactory().openSession();
        User currentUser = session.get(User.class, user_id);
        session.close();
        for (int j = 0; j < 1000; j++) {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Lot currentLot = session.get(Lot.class, (long) ThreadLocalRandom.current().nextInt(1, 5));
            currentLot.setSum(currentLot.getSum() + 100);
            currentLot.setUser(currentUser);
            session.save(currentLot);

            try {
                session.getTransaction().commit();
                System.out.println("Thread "+user_id+" committed");
            } catch (OptimisticLockException e) {
                session.getTransaction().rollback();
                j--;
                System.out.println("Something going wrong: " + e.getMessage());
                System.out.println("Thread "+user_id+" rolled back");
            }

            session.close();

        }
        countDownLatch.countDown();
    }
}


