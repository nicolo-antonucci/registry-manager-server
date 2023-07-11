package com.nicoloantonucci.registrymanagerserver.model;

import jakarta.validation.constraints.NotNull;

public class UpdateRegistryResponse {
    @NotNull
    private Integer page;

    public UpdateRegistryResponse(@NotNull Integer page) {
        this.page = page;
    }

    @NotNull
    public Integer getPage() {
        return page;
    }

    public void setPage(@NotNull Integer page) {
        this.page = page;
    }
}
