package org.enums;

public enum ContentType {
    JSON("application/json");

    private final String contentType;

    ContentType(String contentType) { this.contentType = contentType; }

    public String getContentType() {
        return contentType;
    }
}
