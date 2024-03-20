package com.example.onlineshop.entity.enums;

public enum City {
    BERLIN("Berlin"),
    HAMBURG("Hamburg"),
    MUNICH("Munich"),
    COLOGNE("Cologne"),
    CHICAGO("Chicago"),
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
    HOUSTON("Houston"),
    BONN("Bonn"),
//    MANNHEIM("Mannheim", com.example.onlineshop.entity.enums.Country.USA)
    ;


//    private final Enum Country;
    private final String cityName;
    City(String cityName) {
        this.cityName = cityName;
    }

//    City(String cityName,Enum country) {
//        this.cityName = cityName;
//        this.Country = country;
//    }

    public String getCityName() {
        return cityName;
    }
}
