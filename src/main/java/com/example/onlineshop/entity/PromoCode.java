package com.example.onlineshop.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
public class PromoCode {
    private UUID id;
    private double discount;
    private LocalDate startDate;
    private LocalDate expDate;
    private int maxNumberOfUses;
    private int used;

    public PromoCode(UUID id, double discount, LocalDate startDate, LocalDate expDate, int maxNumberOfUses, int used) {
        this.id = id;
        this.discount = discount;
        this.startDate = startDate;
        this.expDate = expDate;
        this.maxNumberOfUses = maxNumberOfUses;
        this.used = used;
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                "id=" + id +
                ", discount=" + discount +
                ", startDate=" + startDate +
                ", expDate=" + expDate +
                ", maxNumberOfUses=" + maxNumberOfUses +
                ", used=" + used +
                '}';
    }

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
