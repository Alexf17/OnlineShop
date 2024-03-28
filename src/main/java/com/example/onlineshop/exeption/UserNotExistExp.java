package com.example.onlineshop.exeption;

import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
public class UserNotExistExp extends RuntimeException {
    public UserNotExistExp(String message) {
        super(message);
    }

}