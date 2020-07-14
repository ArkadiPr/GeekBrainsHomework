package com.kostandov.geekbrains.homework12.exceptions;


public class NoDbTableAnnotationException extends RuntimeException {
    public NoDbTableAnnotationException() {
    }
    public NoDbTableAnnotationException(String text){
        super(text);
    }
}
