package com.example.onlineshop.controller;

import com.example.onlineshop.entity.Shipper;
import com.example.onlineshop.service.interf.ShipperServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipper")
public class ShipperController {
    private final ShipperServices shipperServices;

    @GetMapping("/showShipper/{name}")
    public Shipper showShipperByName(@PathVariable("name") String name) {
        return shipperServices.showShipper(name);
    }


    @PostMapping("/add")
    public Shipper addNewShipper(@RequestBody Shipper shipper) {
        return shipperServices.addShipper(shipper);
    }
}
