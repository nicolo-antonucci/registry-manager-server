package com.nicoloantonucci.registrymanagerserver.model;

public class ReadRegistriesBody {
    private String name;

    private String surname;

    private String address;

    private String location;

    private String city;

    private String province;

    private String email;

    private String notes;

    public ReadRegistriesBody(String name,
                              String surname,
                              String address,
                              String location,
                              String city,
                              String province,
                              String email,
                              String notes) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.location = location;
        this.city = city;
        this.province = province;
        this.email = email;
        this.notes = notes;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
