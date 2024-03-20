package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Product;
import com.example.onlineshop.service.interf.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductServices productService;
    @GetMapping("/showProduct/{id}")
    public Product showProductById(@PathVariable(name = "id") String id) {

        return productService.showProduct(id);
    }
}
