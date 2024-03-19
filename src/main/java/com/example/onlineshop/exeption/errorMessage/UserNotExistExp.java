package com.example.onlineshop.exeption.errorMessage;

public class UserNotExistExp extends RuntimeException {
    public UserNotExistExp(String message) {
        super(message);
    }
}
