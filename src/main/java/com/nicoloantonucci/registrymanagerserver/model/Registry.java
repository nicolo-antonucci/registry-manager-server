package com.nicoloantonucci.registrymanagerserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "registries")
public class Registry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Pattern(regexp = "^[a-z ,.'-]+$")
    @Column(name = "name")
    private String name;

    @NotNull
    @Pattern(regexp = "^[a-z ,.'-]+$")
    @Column(name = "surname")
    private String surname;

    @Pattern(regexp = "(piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*")
    @Column(name = "address")
    private String address;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    @Column(name = "location")
    private String location;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    @Column(name = "city")
    private String city;

    @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)")
    @Column(name = "province")
    private String province;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "notes")
    private String notes;

    public Registry() {

    }

    public Registry(
            Integer id,
            @NotNull @Pattern(regexp = "^[a-z ,.'-]+$") String name,
            @NotNull @Pattern(regexp = "^[a-z ,.'-]+$") String surname,
            @Pattern(regexp = "(piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*") String address,
            @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String location,
            @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String city,
            @Pattern(regexp = "([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)") String province,
            @NotNull @Email String email,
            String notes
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.location = location;
        this.city = city;
        this.province = province;
        this.email = email;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
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
            @NotNull @Pattern(regexp = "^[a-z ,.'-]+$") String name
    ) {
        this.name = name;
    }

    public void setSurname(
            @NotNull @Pattern(regexp = "^[a-z ,.'-]+$") String surname
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
