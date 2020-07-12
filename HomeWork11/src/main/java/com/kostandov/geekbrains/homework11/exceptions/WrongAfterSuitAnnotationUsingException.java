package com.kostandov.geekbrains.homework11.exceptions;

public class WrongAfterSuitAnnotationUsingException extends RuntimeException {
    public WrongAfterSuitAnnotationUsingException() {
    }

    public WrongAfterSuitAnnotationUsingException(String text){
        super(text);
    }
}
