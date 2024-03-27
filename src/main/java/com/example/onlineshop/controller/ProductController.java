package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Product;
import com.example.onlineshop.entity.Shipper;
import com.example.onlineshop.service.interf.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductServices productService;

    @GetMapping("/showProduct/{id}")
    public Product showProductById(@PathVariable(name = "id") String id) {

        return productService.showProduct(id);
    }

    @GetMapping("/showProduct/all")
    public List<Product> showAllProducts() {

        return productService.showAllProducts();
    }

    @GetMapping("/showProduct/allNames")
    public List<String> showAllProductNames() {

        return productService.showAllProductNames();
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteProduct/{id}")
    void deleteProduct(@PathVariable(name = "id") String id){
        productService.deleteProduct(id);
    }

    @PostMapping("/add")
    public Product addNewShipper(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
