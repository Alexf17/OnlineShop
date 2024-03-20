package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ttt")
public class TestContr {
    @GetMapping( "/{test}")
    public String getStr(@PathVariable(name = "test") String test){
        return test;
    }
}
//31323365-3435-3637-2d65-3839622d3132
//32323365-3435-3637-2d65-3839622d3132