package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class Order {
    private UUID id;
    private Timestamp createdAt;
    private PromoCode usedPromoCode;
    private Status status;
    private Client client;
    private Shipper shipper;

    public Order() {
    }

    public Order(Timestamp createdAt, PromoCode usedPromoCode,
                 Status status, Client client, Shipper shipper) {
        this.createdAt = createdAt;
        this.usedPromoCode = usedPromoCode;
        this.status = status;
        this.client = client;
        this.shipper = shipper;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!id.equals(order.id)) return false;
        if (!createdAt.equals(order.createdAt)) return false;
        return status == order.status;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
