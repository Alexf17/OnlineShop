package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDetail {
    private UUID id;
    private int quantity;
    private Order order;
    private List<Product> products;

    public OrderDetail(UUID id, int quantity, Order order, List<Product> products) {
        this.id = id;
        this.quantity = quantity;
        this.order = order;
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetail that = (OrderDetail) o;

        if (quantity != that.quantity) return false;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + quantity;
        return result;
    }
}
