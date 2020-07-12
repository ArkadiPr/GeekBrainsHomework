package com.kostandov.geekbrains.homework11.testrunner;

import com.kostandov.geekbrains.homework11.annotations.AfterSuite;
import com.kostandov.geekbrains.homework11.annotations.BeforeSuite;
import com.kostandov.geekbrains.homework11.annotations.Test;
import com.kostandov.geekbrains.homework11.exceptions.WrongAfterSuitAnnotationUsingException;
import com.kostandov.geekbrains.homework11.exceptions.WrongBeforeSuitAnnotationUsingException;
import com.kostandov.geekbrains.homework11.test.MyTestClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class TestRunner {

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        Method[] methods=c.getDeclaredMethods();
        Object object=null;

        try {
            object=c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        ArrayList<Method> methodsWithBefore=Arrays.stream(methods).
                filter(method -> method.isAnnotationPresent(BeforeSuite.class)).
                collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Method> methodsWithAfter=Arrays.stream(methods).
                filter(method -> method.isAnnotationPresent(AfterSuite.class)).
                collect(Collectors.toCollection(ArrayList::new));
        Map<Method,Integer>  methodsWithPriority=Arrays.stream(methods).
                filter(method -> method.isAnnotationPresent(Test.class)).
                collect(Collectors.toMap(method -> method,method ->  method.getAnnotation(Test.class).priority()));
        Map<Method, Integer> sortedMethodsByPriority=methodsWithPriority.entrySet().stream().
                sorted(comparingByValue()).
                collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        if(methodsWithBefore.size()>1){
            throw new WrongBeforeSuitAnnotationUsingException("More than 1 BeforeSuit annotation was used");
        }
        if(methodsWithAfter.size()>1){
            throw new WrongAfterSuitAnnotationUsingException("More than 1 AfterSuit annotation was used");
        }

        if(methodsWithBefore.size()!=0){
            methodsWithBefore.get(0).invoke(object);
        }
        for(Method method : sortedMethodsByPriority.keySet()){
            method.invoke(object);
        }
        if(methodsWithAfter.size()!=0){
            methodsWithAfter.get(0).invoke(object);
        }

    }

    public static void main(String[] args) {
        try {
            start(MyTestClass.class);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
