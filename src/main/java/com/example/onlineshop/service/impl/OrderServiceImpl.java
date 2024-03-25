package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Order;
import com.example.onlineshop.exeption.OrderNotExistExp;
import com.example.onlineshop.exeption.ProductNotExistExp;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.repository.OrderRepository;
import com.example.onlineshop.service.interf.OrdersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersServices {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order showOrders(String id) {
        return orderRepository.findById(UUID.fromString(id)).orElseThrow(() -> new OrderNotExistExp(ErrorMessage.ORDER_NOT_EXIST));
    }
}
