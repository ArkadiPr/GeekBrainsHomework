package com.kostandov.geekbrains.homework3.marathon;

import com.kostandov.geekbrains.homework3.marathonMembers.Cat;
import com.kostandov.geekbrains.homework3.marathonMembers.Human;
import com.kostandov.geekbrains.homework3.marathonMembers.Robot;
import com.kostandov.geekbrains.homework3.obstacles.Treadmill;
import com.kostandov.geekbrains.homework3.obstacles.Wall;

import java.io.ObjectStreamClass;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human alesha=new Human("Alesha",200,500);
        Human nastya=new Human("Nastya",300,400);

        Robot valli=new Robot("Valli",900,50);
        Robot transformer=new Robot("Transformer",700,1200);

        Cat barsik=new Cat("Barsik",500,250);
        Cat leopold=new Cat("Leopold",100,150);

        Wall obstacle1=new Wall(30);
        Wall obstacle2=new Wall(70);
        Treadmill obstacle3=new Treadmill(120);
        Treadmill obstacle4=new Treadmill(260);
        Wall obstacle5=new Wall(400);
        Treadmill obstacle6=new Treadmill(550);

        Marathon marathon=new Marathon(Arrays.asList(alesha,nastya,valli,transformer,barsik,leopold)
                ,Arrays.asList(obstacle1,obstacle2,obstacle3,obstacle4,obstacle5,obstacle6));
        marathon.runMarathon();
    }
}
