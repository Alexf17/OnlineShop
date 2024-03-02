package com.example.onlineshop.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Shipper {
    private UUID id;
    private String name;
    private String phone;

    public Shipper() {
    }

    public Shipper(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Shipper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shipper shipper = (Shipper) o;

        if (!id.equals(shipper.id)) return false;
        if (!name.equals(shipper.name)) return false;
        return phone.equals(shipper.phone);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }
}
