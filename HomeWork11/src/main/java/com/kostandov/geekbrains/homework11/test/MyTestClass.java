package com.kostandov.geekbrains.homework11.test;

import com.kostandov.geekbrains.homework11.annotations.AfterSuite;
import com.kostandov.geekbrains.homework11.annotations.BeforeSuite;
import com.kostandov.geekbrains.homework11.annotations.Test;

public class MyTestClass {

    @BeforeSuite
    public  void beforeTestsMethod(){
        System.out.println("BeforeTest is running");
    }
    @Test(priority = 7)
    public  void test1(){
        System.out.println("Method 1 is running with priority 7");
    }
    @Test(priority = 2)
    public  void test2(){
        System.out.println("Method 2 is running with priority 2");
    }

    @Test
    public  void test3(){
        System.out.println("Method 3 is running with default priority");
    }

    @AfterSuite
    public  void afterTestMethod(){
        System.out.println("AfterTest is running");
    }

}
