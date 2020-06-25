package com.kostandov.geekbrains.homework4.exceptions;

public class MyArrayExceptions extends RuntimeException{
    public MyArrayExceptions(){
    }

    public MyArrayExceptions(String text){
        super(text);
    }
}
