package br.com.felixgilioli.releasenotifier.notifier.impl;

import br.com.felixgilioli.releasenotifier.notifier.Notifier;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfo;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.springframework.stereotype.Service;

@Service
public class DiscordNotifierImpl implements Notifier {

    @Override
    public void send(NotificationMessageInfo messageInfo) {
        System.out.println("calling discord notifier");
    }

    @Override
    public NotificationTarget getTarget() {
        return NotificationTarget.DISCORD;
    }
}
