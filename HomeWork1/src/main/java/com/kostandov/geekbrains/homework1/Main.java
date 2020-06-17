package com.kostandov.geekbrains.homework1;


import java.util.Arrays;

public class Main {

    //Task 1
    public static boolean isInRangeSum(int a,int b){

        return ((a+b)>=10&&(a+b)<=20);
    }

    //Task 2
    public static void numberSign(int num){
        if(num>=0){
            System.out.println("Number is positive.");
        }else {
            System.out.println("Number is negative.");
        }
    }

    //Task 3
    public static boolean isNegative(int num){
        return (num<0);
    }

    //Task 4
    public static void greetings(String name){
        System.out.println("Привет, " + name + "!");
    }

    //Task 5
    public static int[] switchZeroesAndOnes(){
        int[] array={1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i=0;i<array.length;i++){
            if(array[i]==0){
                array[i]=1;
            }else {
                array[i]=0;
            }
        }
        return array;
    }

    //Task 6
    public static int[] fillArray(){
        return new int[]{2,5,8,11,14,17,20,23};
    }

    //Task 7
    public static int[] modifyArray(){
        int[] array={ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i=0;i<array.length;i++){
            if(array[i]<6){
                array[i]*=2;
            }
        }
        return array;
    }

    //Task 8
    public static int[][] fillMatrix(){
        int[][] matrix=new int[10][10];
        for(int i=0;i<10;i++){
            matrix[i][i]=1;
        }
        return matrix;
    }

    // Task 9
    public static void findMinMax(int[] array){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int value : array) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Max value is: " + max);
        System.out.println("Min value is: " + min);
    }

    //Task 10
    public  static boolean isLeapYear(int year){
        if(year%400==0){
            return true;
        }else if(year%100==0){
            return false;
        }else {
            return (year%4==0);
        }
    }

    //Task 11
    public static boolean checkBalance(){
        int[] array={1, 1, 1, 2, 1};
        for(int i=0;i<array.length;i++){
            if(sum(Arrays.copyOfRange(array,0,i))==sum(Arrays.copyOfRange(array,i,array.length))){
                return true;
            }
        }
        return false;
    }

    public static int sum(int[] subArray){
        return Arrays.stream(subArray).sum();
    }

    public static void main(String[] args) {
        System.out.println(isInRangeSum(15,-30));
        System.out.println(isNegative(256));
        greetings("Джесика");
        System.out.println(Arrays.toString(switchZeroesAndOnes()));
        System.out.println(Arrays.toString(fillArray()));
        System.out.println(Arrays.toString(modifyArray()));
        System.out.println(Arrays.deepToString(fillMatrix()));
        findMinMax(modifyArray());
        System.out.println(isLeapYear(748));
        System.out.println(checkBalance());

    }
}

