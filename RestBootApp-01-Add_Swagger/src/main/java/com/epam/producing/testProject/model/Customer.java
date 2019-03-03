package com.epam.producing.testProject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Customer {

    private @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    @OneToMany()
    private List<Address> addressList = new ArrayList<>();
    private String name;
    private String surname;
    private String login;
    private String password;

    public Customer() {
        super();
    }

    public Customer(String name, String surname, String login, String password, List<Address> addresses) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.addressList = addresses;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getName().equals(customer.getName()) &&
                getSurname().equals(customer.getSurname()) &&
                getLogin().equals(customer.getLogin()) &&
                getPassword().equals(customer.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getLogin(), getPassword());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", addressList=" + addressList +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
