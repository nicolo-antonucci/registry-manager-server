package com.nicoloantonucci.registrymanagerserver.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class PostRegistryBody {
    @NotNull
    private NewRegistry newRegistry;

    @NotNull
    private ReadRegistriesBody readRegistriesBody;


    public PostRegistryBody(@NotNull NewRegistry newRegistry, @NotNull ReadRegistriesBody readRegistriesBody) {
        this.newRegistry = newRegistry;
        this.readRegistriesBody = readRegistriesBody;
    }

    @NotNull
    public ReadRegistriesBody getReadRegistriesBody() {
        return readRegistriesBody;
    }

    public void setReadRegistriesBody(@NotNull ReadRegistriesBody readRegistriesBody) {
        this.readRegistriesBody = readRegistriesBody;
    }

    @NotNull
    public NewRegistry getNewRegistry() {
        return newRegistry;
    }

    public void setNewRegistry(@NotNull NewRegistry newRegistry) {
        this.newRegistry = newRegistry;
    }
}
