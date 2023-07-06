package com.nicoloantonucci.registrymanagerserver.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class PostRegistryBody {
    @NotNull
    private NewRegistry newRegistry;


    public PostRegistryBody(
            @NotNull NewRegistry newRegistry
    ) {
        this.newRegistry = newRegistry;
    }

    @NotNull
    public NewRegistry getNewRegistry() {
        return newRegistry;
    }

    public void setNewRegistry(@NotNull NewRegistry newRegistry) {
        this.newRegistry = newRegistry;
    }
}
