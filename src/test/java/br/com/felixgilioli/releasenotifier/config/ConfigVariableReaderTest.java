package br.com.felixgilioli.releasenotifier.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class ConfigVariableReaderTest {

    @InjectMocks
    private ConfigVariableReader configVariableReader;

    @Test
    void shouldThrowsExceptionOnPropIsNull() {
        assertThrows(NullPointerException.class, () -> configVariableReader.getValue(null));
    }

}
