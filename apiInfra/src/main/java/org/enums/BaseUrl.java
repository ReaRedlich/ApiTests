package org.enums;

public enum BaseUrl {
    REQRES_BASE_URL("https://reqres.in/");

    private final String baseUrl;

    BaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

    public String getBaseUrl() {
        return baseUrl;
    }
}
