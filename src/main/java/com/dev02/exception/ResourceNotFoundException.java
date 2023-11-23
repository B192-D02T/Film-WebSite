package com.dev02.exception;

public class ResourceNotFoundException extends RuntimeException{//bulunamadı
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
