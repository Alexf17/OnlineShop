package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Order;
import com.example.onlineshop.service.interf.OrdersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrdersServices ordersServices;

    @GetMapping("/showOrders/{id}")
    public Order showOrdersByUserId(@PathVariable(name = "id") String id) {
        return ordersServices.showOrders(id);
    }
}
