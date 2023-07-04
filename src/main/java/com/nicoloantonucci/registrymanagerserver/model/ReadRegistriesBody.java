package com.nicoloantonucci.registrymanagerserver.model;

import jakarta.validation.constraints.NotNull;

public class ReadRegistriesBody {
    @NotNull
    private Integer page = 1;
    @NotNull
    private Integer elementsPerPage = 10;

    public ReadRegistriesBody(
            @NotNull Integer page,
            @NotNull Integer elementsPerPage
    ) {
        this.page = page;
        this.elementsPerPage = elementsPerPage;
    }

    @NotNull
    public Integer getPage() {
        return page;
    }

    public void setPage(@NotNull Integer page) {
        this.page = page;
    }

    @NotNull
    public Integer getElementsPerPage() {
        return elementsPerPage;
    }


    public void setElementsPerPage(@NotNull Integer elementsPerPage) {
        this.elementsPerPage = elementsPerPage;
    }
}
