package com.nicoloantonucci.registrymanagerserver.model;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class ReadRegistriesDto {
    private Set<Registry> registries;

    @NotNull
    private Integer page;

    @NotNull
    private Integer pages;

    @NotNull
    private Integer elementsPerPages;

    @NotNull
    private Integer totalElements;

    public ReadRegistriesDto(
            Set<Registry> registries,
            @NotNull Integer page,
            @NotNull Integer pages,
            @NotNull Integer elementsPerPage,
            @NotNull Integer totalElements
    ) {
        this.registries = registries;
        this.elementsPerPages = elementsPerPage;
        this.page = page;
        this.pages = pages;
        this.totalElements = totalElements;
    }

    public Set<Registry> getRegistries() {
        return registries;
    }

    public void setRegistries(Set<Registry> registries) {
        this.registries = registries;
    }

    @NotNull
    public Integer getPage() {
        return page;
    }

    public void setPage(@NotNull Integer page) {
        this.page = page;
    }

    @NotNull
    public Integer getPages() {
        return pages;
    }

    public void setPages(@NotNull Integer pages) {
        this.pages = pages;
    }

    @NotNull
    public Integer getElementsPerPages() {
        return elementsPerPages;
    }

    public void setElementsPerPages(@NotNull Integer elementsPerPages) {
        this.elementsPerPages = elementsPerPages;
    }

    @NotNull
    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(@NotNull Integer totalElements) {
        this.totalElements = totalElements;
    }
}
