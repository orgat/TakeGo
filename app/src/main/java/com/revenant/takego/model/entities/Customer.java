package com.revenant.takego.model.entities;

/**
 * Created by Or on 20-Dec-17.
 */

public class Customer {
    private String name;
    private String lastName;
    private long id;
    private String phoneNumber;
    private String email;
    private long creditCard;

    public Customer(String name, String lastName, long id, String phoneNumber, String email, long creditCard) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creditCard = creditCard;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        String customer = "ID: " + id +"\n"
                + "Name: " + name + "\n"
                + "Last name: " + lastName + "\n"
                + "Phone number: "+ phoneNumber + "\n"
                + "Email address: " + email + "\n"
                + "Credit card: " + creditCard;
        return customer;
    }
}
