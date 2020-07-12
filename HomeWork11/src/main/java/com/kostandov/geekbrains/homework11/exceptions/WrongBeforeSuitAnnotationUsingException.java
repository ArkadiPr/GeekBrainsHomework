package com.kostandov.geekbrains.homework11.exceptions;

public class WrongBeforeSuitAnnotationUsingException extends RuntimeException {
    public WrongBeforeSuitAnnotationUsingException() {
    }

    public WrongBeforeSuitAnnotationUsingException(String text){
        super(text);
    }
}
