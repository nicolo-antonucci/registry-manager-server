package com.nicoloantonucci.registrymanagerserver.model;

public class UpdateRegistryResponse {
    private Boolean updated;

    public UpdateRegistryResponse(Boolean updated) {
        this.updated = updated;
    }

    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }
}
