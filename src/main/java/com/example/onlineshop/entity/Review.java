package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.Rate;
import com.example.onlineshop.generator.UuidTimeSequenceGenerator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", type = UuidTimeSequenceGenerator.class)
    @Column(name = "r_id")
    private UUID id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private Timestamp date;

    @Column(name = "rate")
    @Enumerated(EnumType.STRING)
    private Rate rate;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "u_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "p_id")
    private Product product;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (!id.equals(review.id)) return false;
        if (!content.equals(review.content)) return false;
        return date.equals(review.date);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
