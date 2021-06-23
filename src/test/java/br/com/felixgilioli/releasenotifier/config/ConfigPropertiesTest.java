package br.com.felixgilioli.releasenotifier.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConfigPropertiesTest {

    @Test
    void getPropertyName() {
        var propertyName = ConfigProperties.MAIL_PASSWORD.getPropertyName();
        Assertions.assertEquals("MAIL_PASSWORD", propertyName);
    }
}
