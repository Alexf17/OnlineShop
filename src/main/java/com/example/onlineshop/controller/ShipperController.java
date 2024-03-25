package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Shipper;
import com.example.onlineshop.service.interf.ShipperServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipper")
public class ShipperController {
    private final ShipperServices shipperServices;

    @GetMapping("/showShipper/{name}")
    public Shipper showShipperByName(@PathVariable("name") String name) {
        return shipperServices.showShipper(name);
    }
}
