package com.example.onlineshop.controller;


import com.example.onlineshop.exeption.UserNotExistExp;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler(UserNotExistExp.class)
    public ResponseEntity<?>  handleUserNotFoundException(Exception exp) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exp.getMessage());
//        return new ResponseEntity<>(new ErrorExtension(
//                exp.getMessage(),ErrorMessage.USER_NOT_EXIST),HttpStatus.NO_CONTENT);
    }
}
