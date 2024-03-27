package com.example.onlineshop.service.impl;

import com.example.onlineshop.entity.Shipper;
import com.example.onlineshop.exeption.ProductNotExistExp;
import com.example.onlineshop.exeption.ShipperNotExistExp;
import com.example.onlineshop.exeption.errorMessage.ErrorMessage;
import com.example.onlineshop.repository.ShipperRepository;
import com.example.onlineshop.service.interf.ShipperServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

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

    @Override
    @Transactional
    public Shipper changeShipper(Shipper shipper, String id) {
        Shipper getShipper = shipperRepository.findById(UUID.fromString(id)).orElseThrow(() -> new ShipperNotExistExp(ErrorMessage.SHIPPER_NOT_EXIST));
        if (getShipper != null) {
            if (!Objects.equals(getShipper.getName(), shipper.getName())) {
                getShipper.setName(shipper.getName());
                shipperRepository.save(getShipper);
            }
            if (!Objects.equals(getShipper.getPhone(), shipper.getPhone())) {
                getShipper.setName(shipper.getPhone());
                shipperRepository.save(getShipper);
            }

        }
        return getShipper;
    }
}
