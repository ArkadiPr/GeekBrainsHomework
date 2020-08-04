package com.kostandov.homework21;


import com.kostandov.homework21.data.PrepareData;
import com.kostandov.homework21.entitys.Item;
import com.kostandov.homework21.entitys.User;
import com.kostandov.homework21.services.ItemService;
import com.kostandov.homework21.services.UserService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class Homework21Application {

    @Bean
    public SessionFactory getSessionFactory(){
        try {
            return new org.hibernate.cfg.Configuration().configure("configs/entitys_config/hibernate.cfg.xml").buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static void main(String[] args) {
        PrepareData.forcePrepareData();
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(Homework21Application.class);


        ItemService itemService=annotationConfigApplicationContext.getBean("itemService",ItemService.class);
        UserService userService=annotationConfigApplicationContext.getBean("userService",UserService.class);

        Item item=new Item("Davd",255);
        User user=new User("Kikos",25);

        userService.saveUser(user);
        itemService.saveItem(item);

        System.out.println(itemService.getItems());
        System.out.println(userService.getUsers());

    }

}
