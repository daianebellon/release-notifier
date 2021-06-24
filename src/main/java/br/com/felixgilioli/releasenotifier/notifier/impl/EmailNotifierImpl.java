package br.com.felixgilioli.releasenotifier.notifier.impl;

import br.com.felixgilioli.releasenotifier.notifier.Notifier;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfo;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotifierImpl implements Notifier {

    private final JavaMailSender mailSender;

    public EmailNotifierImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(NotificationMessageInfo messageInfo) {
        var mailMessage = new SimpleMailMessage();
        mailMessage.setTo("felix_gilioli@hotmail.com");
        mailMessage.setSubject(messageInfo.getSubject());
        mailMessage.setText(messageInfo.getMessage());
        mailSender.send(mailMessage);
    }

    @Override
    public NotificationTarget getTarget() {
        return NotificationTarget.EMAIL;
    }
}
