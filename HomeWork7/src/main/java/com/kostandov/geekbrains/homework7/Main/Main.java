package com.kostandov.geekbrains.homework7.Main;

import com.kostandov.geekbrains.homework7.Main.Task3.MyEntry;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    // Task 1 ArrayList Test
    public static long arrayListGetTest(int n){
        List<Integer> testList=new ArrayList<Integer>(Stream.iterate(0,k->k+1).limit(n).collect(Collectors.toList()));
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            testList.get(n/2);
        }
        return (System.currentTimeMillis()-start);
    }

    //Task 1 LinkedList test
    public static long linkListGetTest(int n){
        List<Integer> testList=new LinkedList<Integer>(Stream.iterate(0, k->k+1).limit(n).collect(Collectors.toList()));
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            testList.get(n/2);
        }
        return (System.currentTimeMillis()-start);
    }

    /*Task 1 results
    _______________________________________
    |           |10  |100  |10000  |100000 |
    |ArrayList  |1   |1    |1      |1      |
    |LinkedList |1   |2    |83     |844    |
    ----------------------------------------
     */

    // Task 2 ArrayList Test
    public static long arrayListRemoveTest(int n){
        List<Integer> testList=new ArrayList<Integer>(Stream.iterate(0,k->k+1).limit(n).collect(Collectors.toList()));
        int m=n;
        long start = System.currentTimeMillis();
        for(int i=0;i<n/2;i++){
            testList.remove(m/2);
            m--;
        }

        return (System.currentTimeMillis()-start);
    }
    //Task 2 LinkedList test
    public static long linkListRemoveTest(int n){
        List<Integer> testList=new LinkedList<Integer>(Stream.iterate(0,k->k+1).limit(n).collect(Collectors.toList()));
        int m=n;
        long start = System.currentTimeMillis();
        for(int i=0;i<n/2;i++){
            testList.remove(m/2);
            m--;
        }

        return (System.currentTimeMillis()-start);
    }

    /*Task 2 results
    _______________________________________
    |           |10  |100  |10000  |100000 |
    |ArrayList  |0   |0    |5      |179    |
    |LinkedList |0   |0    |34     |2981   |
    ----------------------------------------
     */


    //Task 3 ArrayList of MyEntries test
    public static long myEntryArrayListTest(ArrayList<MyEntry> myEntries){
        long start = System.currentTimeMillis();
        int key;
        for(int i=0;i<100000;i++){
            key=ThreadLocalRandom.current().nextInt(0,  49999);
            for(MyEntry entry : myEntries) {
                if (entry.getKey() == key)
                    break;
            }
        }

        return (System.currentTimeMillis()-start);
    }

    //Task 3 HashMap test
    public static long hashMapTest(HashMap<Integer,Integer> hashMapValues){
        long start = System.currentTimeMillis();
        int key;
        for(int i=0;i<100000;i++){
            key=ThreadLocalRandom.current().nextInt(0,  49999);
            hashMapValues.get(key);
        }

        return (System.currentTimeMillis()-start);
    }


    /*Task 3 results
    ___________________________________
    |                         |50000  |
    |ArrayList<MyEntry>       |8590   |
    |HashMap<Integer,Integer> |10     |
    -----------------------------------
     */



    public static void main(String[] args) {
        System.out.println(arrayListRemoveTest(100000));
        System.out.println(linkListRemoveTest(100000));

        int random;

        ArrayList<MyEntry> myEntries=new ArrayList<>(50000);
        HashMap<Integer,Integer> mapTestData=new HashMap<>(50000);
        for(int i=0;i<50000;i++){
            random=ThreadLocalRandom.current().nextInt(0,  50000);
            myEntries.add(new MyEntry(i, random));
            mapTestData.put(0,random);
        }

        System.out.println(myEntryArrayListTest(myEntries));
        System.out.println(hashMapTest(mapTestData));
    }
}
