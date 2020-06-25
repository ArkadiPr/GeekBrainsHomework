package com.kostandov.geekbrains.homework4.main;

import com.kostandov.geekbrains.homework4.exceptions.MyArrayDataException;
import com.kostandov.geekbrains.homework4.exceptions.MyArrayExceptions;
import com.kostandov.geekbrains.homework4.exceptions.MyArraySizeException;

public class Main {
    public static int sumMatrix(String[][] array){
        int sum=0,current;
        if(array.length!=4||array[0].length!=4||array[1].length!=4||array[2].length!=4||array[3].length!=4){
            throw new MyArraySizeException("Метод на вход получил двумерный массив некорректного размера. Корректный ввод 4x4");
        }
        for(int i=0;i<array.length;i++){
            for(int j=0; j<array[0].length;j++){
                try{
                    current=Integer.parseInt(array[i][j]);
                    sum+=current;
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Ошибка преобразования элемента на позиции: "+ i + "x" + j);
                }catch (Exception e){
                    System.out.println("Ошибка при вычислении!");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] array={{"1","2","3","5"},{"1","s","3","6"},{"1","2","3","7"},{"1","2","3","8"}};
        String[][] array2={{"3","1","2","3","5"},{"1","8","3","6"},{"1","2","3","7"},{"1","2","3","8"}};
        try {
            System.out.println(sumMatrix(array));
            System.out.println(sumMatrix(array2));
        }catch (MyArrayExceptions e){
            System.out.println(e.getMessage());
        }
    }
}
