package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "orders_details")
public class OrderDetail {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "com.example.onlineshop.generator.UuidTimeSequenceGenerator")
    @Column(name = "od_id")
    private UUID id;
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "o_id")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "p_id")
    private Product product;


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
