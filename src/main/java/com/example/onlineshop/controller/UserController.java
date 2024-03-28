package com.example.onlineshop.controller;

import com.example.onlineshop.entity.User;
import com.example.onlineshop.service.interf.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userServices;

    @GetMapping("/showUser/{id}")
    public Object  showUserById(@PathVariable(name = "id") String id) {

        return userServices.showUser(id);
    }


}
