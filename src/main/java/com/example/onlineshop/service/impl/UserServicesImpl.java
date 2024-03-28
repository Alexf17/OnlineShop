package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.User;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.exeption.UserNotExistExp;
import com.example.onlineshop.repository.UserRepository;
import com.example.onlineshop.service.interf.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    private final UserRepository userRepository;

    @Override
    @Transactional
//    public Object  showUser(String id) {
//        Optional<User> optionalUser = userRepository.findById(UUID.fromString(id));
//        if (optionalUser.isPresent()) {
//            return ResponseEntity.ok(optionalUser.get());
//        } else {
//
//            ResponseEntity<?> responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body();
//
//            throw new UserNotExistExp(ErrorMessage.USER_NOT_EXIST, responseEntity);
//        }
//    }
    public User showUser(String id) {
        return userRepository
                .findById(UUID.fromString(id))
                .orElseThrow(() -> new UserNotExistExp(ErrorMessage.USER_NOT_EXIST));
    }
}
