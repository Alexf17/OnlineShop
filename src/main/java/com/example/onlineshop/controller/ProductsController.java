package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Product;
import com.example.onlineshop.service.interf.ProductServices;
import com.example.onlineshop.service.interf.ProductsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductsController {
    private final ProductsServices productsService;
    @GetMapping("/showProduct/all")
    public List<Product> showAllProducts() {

        return productsService.showAllProducts();
    }
}
