package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.City;
import com.example.onlineshop.entity.enums.Country;
import com.example.onlineshop.entity.enums.PostCode;
import com.example.onlineshop.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "su_id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column(name = "postcode")
    @Enumerated(EnumType.STRING)
    private PostCode postCode;

    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    private Country country;

    @Column(name = "phone")
    private String phone;

    @JsonBackReference
    @OneToMany(mappedBy = "supplier", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;


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
