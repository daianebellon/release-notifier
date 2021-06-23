package br.com.felixgilioli.releasenotifier.config.integration;

import br.com.felixgilioli.releasenotifier.config.ConfigProperties;
import br.com.felixgilioli.releasenotifier.config.ConfigVariableReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class MailConfigTest {

    @InjectMocks
    private MailConfig mailConfig;

    @Mock
    private ConfigVariableReader configVariableReader;

    @Test
    void getJavaMailSender() {
        when(configVariableReader.getValue(ConfigProperties.MAIL_USERNAME)).thenReturn("naruto@email.com");
        when(configVariableReader.getValue(ConfigProperties.MAIL_PASSWORD)).thenReturn("123456");

        var javaMailSender = mailConfig.getJavaMailSender();

        assertNotNull(javaMailSender);
        verify(configVariableReader, times(1)).getValue(ConfigProperties.MAIL_USERNAME);
        verify(configVariableReader, times(1)).getValue(ConfigProperties.MAIL_PASSWORD);
    }
}
