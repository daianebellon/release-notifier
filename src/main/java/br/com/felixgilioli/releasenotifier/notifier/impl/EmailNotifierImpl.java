package br.com.felixgilioli.releasenotifier.notifier.impl;

import br.com.felixgilioli.releasenotifier.notifier.Notifier;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.springframework.stereotype.Service;

@Service
public class EmailNotifierImpl implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("calling email notifier");
    }

    @Override
    public NotificationTarget getTarget() {
        return NotificationTarget.EMAIL;
    }
}
