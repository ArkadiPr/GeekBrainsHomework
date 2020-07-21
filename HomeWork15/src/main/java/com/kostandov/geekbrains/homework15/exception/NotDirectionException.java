package com.kostandov.geekbrains.homework15.exception;

public class NotDirectionException extends RuntimeException {
    public NotDirectionException() {
    }
    public NotDirectionException(String text){
        super(text);
    }
}
