package br.com.felixgilioli.releasenotifier.config;

import io.github.felixgilioli.felixutils.strings.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

@Component
public class ConfigVariableReader {

    private final Environment environment;

    public ConfigVariableReader(Environment environment) {
        this.environment = environment;
    }

    public String getValue(ConfigProperties property) {
        requireNonNull(property);

        var valueFromEnv = System.getenv(property.getPropertyName());
        if (StringUtils.isNotBlank(valueFromEnv)) {
            return valueFromEnv;
        }

        var propertyFromPropertiesFile = environment.getProperty(property.getPropertyName());

        if (StringUtils.isNotBlank(propertyFromPropertiesFile)) {
            return propertyFromPropertiesFile;
        }

        throw new IllegalArgumentException(String.format("Can't find value of property: [%s]", property));
    }
}
