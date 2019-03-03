package com.epam.producing.testProject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
public class Address {
    private @Id
    @GeneratedValue
    Long id;
    private String country;
    private String region;
    private String city;
    private String street;
    private int apartment;

    public Address() {
        super();
    }

    public Address( String country, String region, String city, String street, int apartment) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.apartment = apartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int appartment) {
        this.apartment = appartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getApartment() == address.getApartment() &&
                getCountry().equals(address.getCountry()) &&
                getRegion().equals(address.getRegion()) &&
                getCity().equals(address.getCity()) &&
                getStreet().equals(address.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getRegion(), getCity(), getStreet(), getApartment());
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", street='" + street + '\'' +
                ", apartment=" + apartment +
                '}';
    }
}
