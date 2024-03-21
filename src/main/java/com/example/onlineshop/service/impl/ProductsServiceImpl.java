package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Product;
import com.example.onlineshop.exeption.ProductNotExistExp;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.repository.ProductRepository;
import com.example.onlineshop.repository.ProductsRepository;
import com.example.onlineshop.service.interf.ProductServices;
import com.example.onlineshop.service.interf.ProductsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsServices {
    private final ProductsRepository productsRepository;
@Override
    @Transactional
    public List<Product> showAllProducts() {

        return productsRepository.findAll();
    }



}
