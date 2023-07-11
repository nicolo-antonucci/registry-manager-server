package com.nicoloantonucci.registrymanagerserver.model;

public class DeleteRegistryResponse {
    private Boolean deleted;

    public DeleteRegistryResponse(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
