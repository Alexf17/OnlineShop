package com.example.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "promo_codes")
public class PromoCode {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "com.example.onlineshop.generator.UuidTimeSequenceGenerator")
    @Column(name = "pc_id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "discount")
    private double discount;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "exp_date")
    private LocalDate expDate;

    @Column(name = "max_number_of_uses")
    private int maxNumberOfUses;

    @Column(name = "used")
    private int used;

    @JsonBackReference
    @OneToMany(mappedBy = "usedPromoCode", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Order> promoOrders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromoCode promoCode = (PromoCode) o;

        if (Double.compare(discount, promoCode.discount) != 0) return false;
        if (maxNumberOfUses != promoCode.maxNumberOfUses) return false;
        return id.equals(promoCode.id);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + maxNumberOfUses;
        return result;
    }
}
