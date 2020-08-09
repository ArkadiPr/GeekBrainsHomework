package com.kostandov.geekbrains.homework23.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
    }

    public ResourceNotFoundException(String text){
        super(text);
    }
}
