package com.example.onlineshop.exeption;

public class UserNotExistExp extends RuntimeException {
    public UserNotExistExp(String message) {
        super(message);
    }
}
