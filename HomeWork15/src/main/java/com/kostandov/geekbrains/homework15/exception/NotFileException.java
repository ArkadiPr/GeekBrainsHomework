package com.kostandov.geekbrains.homework15.exception;

public class NotFileException extends RuntimeException {
    public NotFileException() {
    }
    public NotFileException(String text){
        super(text);
    }
}
