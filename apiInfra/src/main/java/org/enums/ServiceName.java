package org.enums;

public enum ServiceName {
    REQRES("reqres");

    private final String service;

    ServiceName(String service) { this.service = service; }

    public String getServiceName() {
        return service;
    }
}
