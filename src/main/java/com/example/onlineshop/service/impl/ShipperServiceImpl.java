package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Shipper;
import com.example.onlineshop.exeption.ProductNotExistExp;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.repository.ShipperRepository;
import com.example.onlineshop.service.interf.ShipperServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShipperServiceImpl implements ShipperServices {
    private final ShipperRepository shipperRepository;

    @Override
    @Transactional
    public Shipper showShipper(String name) {
        return shipperRepository.findByName(name).orElseThrow(() -> new ProductNotExistExp(ErrorMessage.PRODUCT_NOT_EXIST));
    }

    @Transactional
    public Shipper addShipper(Shipper shipper) {
//        Optional<Shipper> optionalShipper = shipperRepository.findByName(shipper.getName());
        return shipperRepository.saveAndFlush(shipper);
    }
}
