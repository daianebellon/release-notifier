package br.com.felixgilioli.releasenotifier.notifier;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;

public interface Notifier {

    void send(String message);

    NotificationTarget getTarget();
}
