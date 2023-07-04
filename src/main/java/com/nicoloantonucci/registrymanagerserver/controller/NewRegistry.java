package com.nicoloantonucci.registrymanagerserver.controller;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class NewRegistry {
    @NotNull(message = "Name must not be null")
    @Pattern(regexp = "^[A-Za-z ,.'-]+$", message = "Name must satisfy regexp ^[A-Za-z ,.'-]+$")
    private String name;

    @NotNull(message = "Surname must not be null")
    @Pattern(regexp = "^[A-Za-z ,.'-]+$", message = "Surname must satisfy regexp ^[A-Za-z ,.'-]+$")
    private String surname;

    @Pattern(regexp = "(piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*")
    private String address;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    private String location;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    private String city;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    private String province;

    @NotNull(message = "Email must not be null")
    @Email(message = "Email must be valid")
    private String email;

    private String notes;

    public NewRegistry(
            @NotNull @Pattern(regexp = "^[A-Za-z ,.'-]+$") String name,
            @NotNull @Pattern(regexp = "^[A-Za-z ,.'-]+$") String surname,
            @Pattern(regexp = "(piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*") String address,
            @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String location,
            @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String city,
            @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String province,
            @NotNull @Email String email,
            String notes
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.location = location;
        this.city = city;
        this.province = province;
        this.email = email;
        this.notes = notes;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public String getNotes() {
        return notes;
    }

    public void setName(
            @NotNull @Pattern(regexp = "^[A-Za-z ,.'-]+$") String name
    ) {
        this.name = name;
    }

    public void setSurname(
            @NotNull @Pattern(regexp = "^[A-Za-z ,.'-]+$") String surname
    ) {
        this.surname = surname;
    }

    public void setAddress(@Pattern(regexp = "(piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*") String address) {
        this.address = address;
    }

    public void setLocation(@Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String location) {
        this.location = location;
    }

    public void setCity(@Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String city) {
        this.city = city;
    }

    public void setProvince(@Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String province) {
        this.province = province;
    }

    public void setEmail(
            @NotNull @Email String email
    ) {
        this.email = email;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
