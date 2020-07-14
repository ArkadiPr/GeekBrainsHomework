package com.kostandov.geekbrains.homework12.exceptions;

public class NoDbIdAnnotationException extends RuntimeException {
    public NoDbIdAnnotationException() {
    }
    public NoDbIdAnnotationException(String text){
        super(text);
    }
}
