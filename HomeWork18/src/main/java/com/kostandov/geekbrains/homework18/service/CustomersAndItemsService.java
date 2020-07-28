package com.kostandov.geekbrains.homework18.service;


import com.kostandov.geekbrains.homework18.entitys.Customer;
import com.kostandov.geekbrains.homework18.entitys.Item;
import com.kostandov.geekbrains.homework18.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomersAndItemsService {
    Session session;

    public CustomersAndItemsService() {
        session= null;
    }

    public List<Item> showProductsByConsumer(String name){
        session=HibernateUtil.getSessionFactory().openSession();

        TypedQuery<Item> itemsByConsumerQuery=session.createQuery("select distinct item \n" +
                "from Item item  \n" +
                "join item.customers customer \n" +
                "where customer.name = :name");
        List<Item> itemsByConsumer=itemsByConsumerQuery.setParameter("name",name).getResultList();

        session.close();
        return itemsByConsumer;
    }

    public List<Customer> showConsumersByProductTitle(String title){
        session=HibernateUtil.getSessionFactory().openSession();

        TypedQuery<Customer> consumersByItemTitleQuery=session.createQuery("select distinct customer \n" +
                "from Customer customer  \n" +
                "join customer.items item \n" +
                "where item.title = :title");
        List<Customer> consumersByItemTitle=consumersByItemTitleQuery.setParameter("title",title).getResultList();

        session.close();
        return consumersByItemTitle;
    }

    public void deleteConsumer(String name){
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query=session.createQuery("DELETE FROM Customer c WHERE c.name = :name");
        query.setParameter("name",name).executeUpdate();

        session.getTransaction().commit();
        session.close();

    }

    public void deleteProduct(String title){
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query=session.createQuery("DELETE FROM Item c WHERE c.title = :title");
        query.setParameter("title",title).executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public void buy(Long customerId,Long itemId){
        session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Customer currentCustomer=session.get(Customer.class,customerId);
        Item currentItem=session.get(Item.class,itemId);
        currentCustomer.getItems().add(currentItem);
        currentItem.getCustomers().add(currentCustomer);

        session.getTransaction().commit();
        session.close();
    }

}
