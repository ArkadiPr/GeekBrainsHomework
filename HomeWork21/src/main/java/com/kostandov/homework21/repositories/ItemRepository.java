package com.kostandov.homework21.repositories;

import com.kostandov.homework21.entitys.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ItemRepository {


    SessionFactory sessionFactory;
    Session session;

    public ItemRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Item save(Item item) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(item);

        session.getTransaction().commit();
        session.close();

        return item;
    }

    public Item loadById(Long itemId) {
        session = sessionFactory.openSession();
        session.beginTransaction();

        Item item = session.get(Item.class, itemId);

        session.getTransaction().commit();
        session.close();

        return item;
    }

    public List<Item> findAll() {
        session = sessionFactory.openSession();
        session.beginTransaction();

        List<Item> items = session.createQuery("SELECT a FROM Item a", Item.class).getResultList();

        session.getTransaction().commit();
        session.close();

        return items;
    }
}
