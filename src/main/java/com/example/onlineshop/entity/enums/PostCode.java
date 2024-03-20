package com.example.onlineshop.entity.enums;

public enum PostCode {

    BERLIN("10115"),
    CHICAGO("60601"),
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
    MANNHEIM("68159"),
    KYIV("01001"),
    KHARKIV("61001"),
    ODESA("65000"),
    LVIV("79000"),
    DNIPRO("49000"),
    DONETSK("83000"),
    ZAPORIZHIA("69000"),
    IVANO_FRANKIVSK("76000"),
    LUTSK("43000"),
    MYKOLAIV("54000"),
    VINNYTSIA("21000"),
    RIVNE("33000"),
    CHERNIVTSI("58000"),
    ZHYTOMYR("10000"),
    SUMY("40000"),
    TERNOPIL("46000"),
    UZHGOROD("88000"),
    KHMELNYTSKYI("29000"),
    CHERKASY("18000"),
    POLTAVA("36000"),
    NEW_YORK("10001"),
    LOS_ANGELES("90001"),
    HD34U("60601"),
    HD87R("60601"),
    W7RTY3I("60001"),
    HOUSTON("77001"),
    PHILADELPHIA("19101"),
    PHOENIX("85001"),
    SAN_ANTONIO("78201"),
    SAN_DIEGO("92101"),
    DALLAS("75201"),
    SAN_JOSE("95101"),
    AUSTIN("73301"),
    JACKSONVILLE("32099"),
    SAN_FRANCISCO("94101"),
    INDIANAPOLIS("46201"),
    COLUMBUS("43201"),
    FORT_WORTH("76101"),
    CHARLOTTE("28201"),
    SEATTLE("98101"),
    DENVER("80201"),
    EL_PASO("79901");

    private final String postalCode;

    PostCode(String postalCode) {
        this.postalCode = postalCode;
    }

        public String getPostalCode() {
        return postalCode;
    }

//    public static String getPostalCode(City city) {
//        for (PostCode postCode : PostCode.values()) {
//            if (postCode.name().equals(city.name())) {
//                return postCode.postalCode;
//            }
//        }
//        return null;
//    }
}
