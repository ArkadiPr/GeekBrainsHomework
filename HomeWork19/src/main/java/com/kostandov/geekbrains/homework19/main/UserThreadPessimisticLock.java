package com.kostandov.geekbrains.homework19.main;

import com.kostandov.geekbrains.homework19.entitys.Lot;
import com.kostandov.geekbrains.homework19.entitys.User;
import com.kostandov.geekbrains.homework19.hibernate.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.LockModeType;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class UserThreadPessimisticLock implements Runnable{

    Session session;
    CountDownLatch countDownLatch;
    Long user_id;

    public UserThreadPessimisticLock(CountDownLatch countDownLatch, Long user_id) {
        this.countDownLatch = countDownLatch;
        this.user_id = user_id;
        session=null;

    }

    @Override
    public void run() {
        session = HibernateUtil.getSessionFactory().openSession();
        User currentUser = session.get(User.class, user_id);
        session.close();
        long lotId;
        for (int j = 0; j < 1000; j++) {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            lotId = (long) ThreadLocalRandom.current().nextInt(1, 5);
            Lot currentLot = session.createQuery("SELECT l FROM Lot l where id=:lotId", Lot.class)
                    .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                    .setParameter("lotId", lotId)
                    .getSingleResult();
            currentLot.setSum(currentLot.getSum() + 100);
            currentLot.setUser(currentUser);
            session.save(currentLot);

            session.getTransaction().commit();
            session.close();
        }
        countDownLatch.countDown();

    }
}
