package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Product;
import com.example.onlineshop.entity.Shipper;
import com.example.onlineshop.exeption.ProductNotExistExp;
import com.example.onlineshop.exeption.UserNotExistExp;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.repository.ProductRepository;
import com.example.onlineshop.service.interf.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServices {
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Product showProduct(String id) {
        return productRepository.findById(UUID.fromString(id)).orElseThrow(() -> new ProductNotExistExp(ErrorMessage.PRODUCT_NOT_EXIST));
    }

    @Override
    @Transactional
    public List<Product> showAllProducts() {

        return productRepository.findAll();
    }

    @Override
    @Transactional
    public List<String> showAllProductNames() {
        return productRepository.findAll().stream().map(Product::getName).toList();
    }

    @Override
    @Transactional
    public void deleteProduct(String id) {
        productRepository.deleteById(UUID.fromString(id));
    }

    @Transactional
    public Product addProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }
}
