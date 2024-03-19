package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.User;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.exeption.errorMessage.UserNotExistExp;
import com.example.onlineshop.repository.UserRepository;
import com.example.onlineshop.service.interf.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    private final UserRepository userRepository;
    @Override
    @Transactional
    public User showUser(String id) {
        return userRepository
                .findById(UUID.fromString(id))
                .orElseThrow(()->new UserNotExistExp(ErrorMessage.USER_NOT_EXIST));

    }
}
