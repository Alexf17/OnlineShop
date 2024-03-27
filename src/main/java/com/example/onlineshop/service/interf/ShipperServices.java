package com.example.onlineshop.service.interf;

import com.example.onlineshop.entity.Shipper;

public interface ShipperServices {
    Shipper showShipper(String name);

    Shipper addShipper(Shipper shipper);

    Shipper changeShipper(Shipper shipper,String id);
}
