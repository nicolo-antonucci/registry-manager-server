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
    @SequenceGenerator(name = "registries_seq", sequenceName = "registries_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registries_seq")
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Name must not be null")
    @Pattern(regexp = "^[A-Za-z ,.'-]+$", message = "Name must satisfy regexp ^[A-Za-z ,.'-]+$")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Surname must not be null")
    @Pattern(regexp = "^[A-Za-z ,.'-]+$", message = "Surname must satisfy regexp ^[A-Za-z ,.'-]+$")
    @Column(name = "surname")
    private String surname;

    @Pattern(regexp = "^((piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$")
    @Column(name = "address")
    private String address;

    @Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$")
    @Column(name = "location")
    private String location;

    @Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$")
    @Column(name = "city")
    private String city;

    @Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$")
    @Column(name = "province")
    private String province;

    @NotNull(message = "Email must not be null")
    @Email(message = "Email must be valid")
    @Column(name = "email")
    private String email;

    @Column(name = "notes")
    private String notes;

    public Registry() {

    }

    public Registry(
            Integer id,
            @NotNull @Pattern(regexp = "^[A-Za-z ,.'-]+$") String name,
            @NotNull @Pattern(regexp = "^[A-Za-z ,.'-]+$") String surname,
            @Pattern(regexp = "^((piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$") String address,
            @Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$") String location,
            @Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$") String city,
            @Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$") String province,
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

    public Registry(NewRegistry newRegistry) {
        this.name = newRegistry.getName();
        this.city = newRegistry.getCity();
        this.address = newRegistry.getAddress();
        this.location = newRegistry.getLocation();
        this.surname = newRegistry.getSurname();
        this.email = newRegistry.getEmail();
        this.notes = newRegistry.getNotes();
        this.province = newRegistry.getProvince();
    }

    public Registry(UpdateRegistryBody updateRegistryBody) {
        this.id = updateRegistryBody.getId();
        this.name = updateRegistryBody.getName();
        this.city = updateRegistryBody.getCity();
        this.address = updateRegistryBody.getAddress();
        this.location = updateRegistryBody.getLocation();
        this.surname = updateRegistryBody.getSurname();
        this.email = updateRegistryBody.getEmail();
        this.notes = updateRegistryBody.getNotes();
        this.province = updateRegistryBody.getProvince();
    }

    public Registry(@NotNull Integer id, NewRegistry updatedRegistry) {
        this.id = id;
        this.name = updatedRegistry.getName();
        this.city = updatedRegistry.getCity();
        this.address = updatedRegistry.getAddress();
        this.location = updatedRegistry.getLocation();
        this.surname = updatedRegistry.getSurname();
        this.email = updatedRegistry.getEmail();
        this.notes = updatedRegistry.getNotes();
        this.province = updatedRegistry.getProvince();
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
            @NotNull @Pattern(regexp = "^[A-Za-z ,.'-]+$") String name
    ) {
        this.name = name;
    }

    public void setSurname(
            @NotNull @Pattern(regexp = "^[A-Za-z ,.'-]+$") String surname
    ) {
        this.surname = surname;
    }

    public void setAddress(@Pattern(regexp = "^((piazza|via|viale)\\s[A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$") String address) {
        this.address = address;
    }

    public void setLocation(@Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$") String location) {
        this.location = location;
    }

    public void setCity(@Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$") String city) {
        this.city = city;
    }

    public void setProvince(@Pattern(regexp = "^([A-Z][A-Za-z']+(\\s[A-Za-z']+)*)?$") String province) {
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
