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
    private Integer size;

    @NotNull
    private Integer totalElements;

    private Integer highlightedElement;

    public ReadRegistriesDto(
            Set<Registry> registries,
            @NotNull Integer page,
            @NotNull Integer pages,
            @NotNull Integer size,
            @NotNull Integer totalElements,
            Integer highlightedElement
    ) {
        this.registries = registries;
        this.size = size;
        this.page = page;
        this.pages = pages;
        this.totalElements = totalElements;
        this.highlightedElement = highlightedElement;
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

    public Integer getHighlightedElement() {
        return highlightedElement;
    }

    public void setPages(@NotNull Integer pages) {
        this.pages = pages;
    }

    @NotNull
    public Integer getSize() {
        return size;
    }

    public void setSize(@NotNull Integer size) {
        this.size = size;
    }

    @NotNull
    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(@NotNull Integer totalElements) {
        this.totalElements = totalElements;
    }

    public void setHighlightedElement(Integer highlightedElement) {
        this.highlightedElement = highlightedElement;
    }
}
