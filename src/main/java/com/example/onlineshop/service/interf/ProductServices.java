package com.example.onlineshop.service.interf;

import com.example.onlineshop.entity.Product;

import java.util.List;

public interface ProductServices {
    Product showProduct(String id);

    List<Product> showAllProducts();

    List<String> showAllProductNames();

    void deleteProduct(String id);
}
