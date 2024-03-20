package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Product;
import com.example.onlineshop.exeption.ProductNotExistExp;
import com.example.onlineshop.exeption.UserNotExistExp;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.repository.ProductRepository;
import com.example.onlineshop.service.interf.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServices {
    private final ProductRepository productRepository;
    @Override
    @Transactional
    public Product showProduct(String id) {
        return productRepository.findById(UUID.fromString(id)).orElseThrow(()->new ProductNotExistExp(ErrorMessage.PRODUCT_NOT_EXIST));
    }
}
