package com.example.onlineshop.entity.enums;

public enum City {
    BERLIN("Berlin"),
    HAMBURG("Hamburg"),
    MUNICH("Munich"),
    COLOGNE("Cologne"),
    FRANKFURT("Frankfurt"),
    STUTTGART("Stuttgart"),
    DUSSELDORF("Dusseldorf"),
    DORTMUND("Dortmund"),
    ESSEN("Essen"),
    LEIPZIG("Leipzig"),
    BREMEN("Bremen"),
    DRESDEN("Dresden"),
    HANOVER("Hanover"),
    NUREMBERG("Nuremberg"),
    DUISBURG("Duisburg"),
    BOCHUM("Bochum"),
    WUPPERTAL("Wuppertal"),
    BIELEFELD("Bielefeld"),
    BONN("Bonn"),
    MANNHEIM("Mannheim");

    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}
