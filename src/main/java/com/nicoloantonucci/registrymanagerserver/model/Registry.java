package com.nicoloantonucci.registrymanagerserver.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Registry {
    @NotNull
    private String name;

    @NotNull
    private String surname;

    @Pattern(regexp = "(piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*")
    private String address;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    private String location;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    private String city;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    private String province;

    @NotNull
    @Email
    private String email;

    private String notes;

    public Registry(
            @NotNull String name,
            @NotNull String surname,
            @NotNull String email
    ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public void setSurname(@NotNull String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
