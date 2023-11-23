package com.dev02.exception;

public class ConflictException extends RuntimeException {//çakışma
    public ConflictException(String message) {
        super(message);
    }
}