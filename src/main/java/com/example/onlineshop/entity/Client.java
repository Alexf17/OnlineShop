package com.example.onlineshop.entity;

import com.example.onlineshop.entity.enums.City;
import com.example.onlineshop.entity.enums.Country;
import com.example.onlineshop.entity.enums.PostCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;
@Getter
@Setter
public class Client {
    private UUID id;
    private String firstName;
    private String secondName;
    private String address;
    private City city;
    private PostCode postCode;
    private Country country;
    private String phone;
    private Timestamp dateOfBirth;
    private String cardNumber;

    public Client() {
    }

    public Client(String firstName, String secondName, String address,
                  City city, PostCode postCode, Country country, String phone,
                  Timestamp dateOfBirth, String cardNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", postCode=" + postCode +
                ", country=" + country +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!firstName.equals(client.firstName)) return false;
        if (!address.equals(client.address)) return false;
        if (!phone.equals(client.phone)) return false;
        return cardNumber.equals(client.cardNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + cardNumber.hashCode();
        return result;
    }
}
