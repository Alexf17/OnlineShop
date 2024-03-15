package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.Status;
import com.example.onlineshop.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.Objects;
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
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
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

        if (!Objects.equals(id, order.id)) return false;
        if (!Objects.equals(createdAt, order.createdAt)) return false;
        return Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
