package br.com.felixgilioli.releasenotifier.config.integration;

import br.com.felixgilioli.releasenotifier.config.ConfigProperties;
import br.com.felixgilioli.releasenotifier.config.ConfigVariableReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    private final ConfigVariableReader configVariableReader;

    public MailConfig(ConfigVariableReader configVariableReader) {
        this.configVariableReader = configVariableReader;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        var mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(configVariableReader.getValue(ConfigProperties.MAIL_USERNAME));
        mailSender.setPassword(configVariableReader.getValue(ConfigProperties.MAIL_PASSWORD));

        var props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}
