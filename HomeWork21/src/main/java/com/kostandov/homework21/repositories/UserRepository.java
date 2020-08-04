package com.kostandov.homework21.repositories;

import com.kostandov.homework21.entitys.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    SessionFactory sessionFactory;
    Session session;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User save(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();

        return user;
    }

    public User loadById(Long userId) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        User user = session.get(User.class, userId);

        session.getTransaction().commit();
        session.close();

        return user;
    }

    public List<User> findAll() {
        session = sessionFactory.openSession();
        session.beginTransaction();

        List<User> users = session.createQuery("SELECT a FROM User a", User.class).getResultList();

        session.getTransaction().commit();
        session.close();

        return users;
    }
}
