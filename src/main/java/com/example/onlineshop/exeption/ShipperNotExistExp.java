package com.example.onlineshop.exeption;

public class ShipperNotExistExp extends RuntimeException {
    public ShipperNotExistExp(String message) {
        super(message);
    }
}
