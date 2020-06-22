package com.kostandov.geekbrains.homework3.marathonMembers;

import com.kostandov.geekbrains.homework3.obstacles.MarathonObstacle;
import com.kostandov.geekbrains.homework3.obstacles.Treadmill;
import com.kostandov.geekbrains.homework3.obstacles.Wall;

public class Human implements Runnable,Jumping {
    private String name;
    private int maxLength;
    private  int maxHeight;


    public Human(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    public boolean passObstacle(MarathonObstacle obstacle) {
        if(obstacle instanceof Wall){
            return jump((Wall)obstacle);
        }
        return run((Treadmill)obstacle);
    }

    public boolean jump(Wall wall) {
        if(wall.getHeight()>this.maxHeight){
            System.out.println("Human " + name + " could not jump wall with height " + wall.getHeight() +"." + name + " is out of marathon.");
            return false;
        }
        System.out.println("Human " + name + " jump wall with height " + wall.getHeight() + "." + name + "  continue the marathon.");
        return true;
    }

    public boolean run(Treadmill treadmill) {
        if(treadmill.getLength()>this.maxLength){
            System.out.println("Human " + name + " could not run treadmill with distance " + treadmill.getLength() + "." + name + "  is out of marathon.");
            return false;
        }
        System.out.println("Human " + name + " run treadmill with distance " + treadmill.getLength() + "." + name + " continue the marathon.");
        return true;
    }


}
