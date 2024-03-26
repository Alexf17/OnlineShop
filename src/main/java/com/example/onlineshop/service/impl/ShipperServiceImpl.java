package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Shipper;
import com.example.onlineshop.exeption.ProductNotExistExp;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.repository.ShipperRepositoty;
import com.example.onlineshop.service.interf.ShipperServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShipperServiceImpl implements ShipperServices {
    private final ShipperRepositoty shipperRepository;

    @Override
    @Transactional
    public Shipper showShipper(String name) {
        return shipperRepository.findByName(name).orElseThrow(() -> new ProductNotExistExp(ErrorMessage.PRODUCT_NOT_EXIST));
    }

    @Transactional
    public Shipper addShipper(Shipper shipper) {
        return shipperRepository.saveAndFlush(shipper);
    }
}
