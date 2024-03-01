package com.example.onlineshop.entity.enums;

public enum PostCode {

    BERLIN("10115"),
    HAMBURG("20095"),
    MUNICH("80331"),
    COLOGNE("50667"),
    FRANKFURT("60311"),
    STUTTGART("70173"),
    DUSSELDORF("40213"),
    DORTMUND("44135"),
    ESSEN("45127"),
    LEIPZIG("04109"),
    BREMEN("28195"),
    DRESDEN("01067"),
    HANOVER("30159"),
    NUREMBERG("90402"),
    DUISBURG("47051"),
    BOCHUM("44787"),
    WUPPERTAL("42103"),
    BIELEFELD("33602"),
    BONN("53111"),
    MANNHEIM("68159");

    private final String postalCode;

    PostCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
