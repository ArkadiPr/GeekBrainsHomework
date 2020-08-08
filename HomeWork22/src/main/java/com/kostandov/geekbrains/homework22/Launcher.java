package com.kostandov.geekbrains.homework22;

import com.kostandov.geekbrains.homework22.data.PrepareData;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.security.ProtectionDomain;

@Configuration
public class Launcher {

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

    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);
        PrepareData.forcePrepareData();

        ProtectionDomain domain = com.kostandov.geekbrains.homework22.Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/app");
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);
        server.start();
        server.join();


    }
}