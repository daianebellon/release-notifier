package br.com.felixgilioli.releasenotifier.config;

public enum ConfigProperties {
    MAIL_USERNAME("MAIL_USERNAME"),
    MAIL_PASSWORD("MAIL_PASSWORD");

    private final String propertyName;

    ConfigProperties(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
