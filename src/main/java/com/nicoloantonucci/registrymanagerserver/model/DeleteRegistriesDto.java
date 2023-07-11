package com.nicoloantonucci.registrymanagerserver.model;

public class DeleteRegistriesDto {
    Boolean success;

    public DeleteRegistriesDto(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
