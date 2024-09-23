package org.converter.enums;

public enum Extension {
    JSON("json"),
    YAML("yaml");

    private String extension;

    Extension(String s) {
        this.extension = s;
    }

    public String getExtension() {
        return extension;
    }
}
