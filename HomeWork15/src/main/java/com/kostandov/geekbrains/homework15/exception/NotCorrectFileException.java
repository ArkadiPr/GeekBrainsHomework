package com.kostandov.geekbrains.homework15.exception;

public class NotCorrectFileException extends RuntimeException {
    public NotCorrectFileException() {
    }
    public NotCorrectFileException(String text){
        super(text);
    }
}
