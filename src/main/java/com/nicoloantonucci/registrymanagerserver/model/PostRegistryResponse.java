package com.nicoloantonucci.registrymanagerserver.model;

public class PostRegistryResponse {
    private Boolean posted;

    public PostRegistryResponse(Boolean posted) {
        this.posted = posted;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }
}
