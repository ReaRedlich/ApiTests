package org.enums;

public enum Service {
    REQRES("reqres");

    private final String service;

    Service(String service) { this.service = service; }

    public String getService() {
        return service;
    }
}
