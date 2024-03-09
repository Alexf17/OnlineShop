package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "com.example.onlineshop.generator.UuidTimeSequenceGenerator")
    @Column(name = "o_id")
    private UUID id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "status")
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "promo_code_id", referencedColumnName = "pc_id")
    private PromoCode usedPromoCode;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "u_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shipper_id", referencedColumnName = "sh_id")
    private Shipper shipper;

    @JsonBackReference
    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;



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
