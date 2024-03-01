package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.City;
import com.example.onlineshop.entity.enums.Country;
import com.example.onlineshop.entity.enums.PostCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Supplier {
    private UUID id;
    private String name;
    private String address;
    private City city;
    private PostCode postCode;
    private Country country;
    private String phone;

    public Supplier(UUID id, String name, String address, City city,
                    PostCode postCode, Country country, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", postCode=" + postCode +
                ", country=" + country +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        if (!id.equals(supplier.id)) return false;
        if (!name.equals(supplier.name)) return false;
        if (!address.equals(supplier.address)) return false;
        return phone.equals(supplier.phone);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}
