package com.kostandov.geekbrains.homework14.exception;

public class MyFileException extends RuntimeException {
    public MyFileException() {
    }
    public MyFileException(String text){
        super(text);
    }
}
