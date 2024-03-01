package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.Rate;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class Review {
    private UUID id;
    private String content;
    private Timestamp date;
    private Rate rate;
    private Client client;
    private Product product;

    public Review(UUID id, String content, Timestamp date, Rate rate, Client client, Product product) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.rate = rate;
        this.client = client;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", rate=" + rate +
                '}';
    }

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
