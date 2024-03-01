package com.example.onlineshop.entity.enums;

public enum Country {
    USA("United States of America"),
    GERMANY("Germany"),
    UKRAINE("Ukraine");

    private final String country;

    Country(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

}