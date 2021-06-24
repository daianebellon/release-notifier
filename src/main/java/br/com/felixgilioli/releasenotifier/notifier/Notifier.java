package br.com.felixgilioli.releasenotifier.notifier;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfo;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;

public interface Notifier {

    void send(NotificationMessageInfo messageInfo);

    NotificationTarget getTarget();
}
