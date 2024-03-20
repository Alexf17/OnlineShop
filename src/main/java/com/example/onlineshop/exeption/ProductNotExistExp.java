package com.example.onlineshop.exeption;

public class ProductNotExistExp extends RuntimeException {
    public ProductNotExistExp(String message) {
        super(message);
    }
}
