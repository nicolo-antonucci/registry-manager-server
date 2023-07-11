package com.nicoloantonucci.registrymanagerserver.model;

public class ResponseSchema<TPayload, TError> {
    private Boolean success;
    private TPayload payload;
    private TError error;

    public ResponseSchema(Boolean success, TPayload payload, TError error) {
        this.success = success;
        this.payload = payload;
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public TPayload getPayload() {
        return payload;
    }

    public void setPayload(TPayload payload) {
        this.payload = payload;
    }

    public TError getError() {
        return error;
    }

    public void setError(TError error) {
        this.error = error;
    }
}
