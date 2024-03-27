package com.example.onlineshop.controller.util;

import com.example.onlineshop.entity.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class Generator {
    public static Product getProduct(){
        Product product = new Product();
        product.setName("XBOX SERIES X 1TB");
        product.setDescription("Kickstart your ultimate adventure with Xbox Series X and the Forza\nHorizon 5 Premium Edition. ");
        product.setId(UUID.fromString("32643131-6162-3831-2d66-6632372d3438"));
        product.setQuantity(12);
        product.setPrice(BigDecimal.valueOf(300.500));
        product.setActive(true);
        return  product;
    }
}
