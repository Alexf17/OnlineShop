package com.example.onlineshop.exeption;

public class OrderNotExistExp extends RuntimeException {
    public OrderNotExistExp(String message) {
        super(message);
    }
}
