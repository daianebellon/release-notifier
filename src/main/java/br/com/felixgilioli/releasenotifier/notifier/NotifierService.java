package br.com.felixgilioli.releasenotifier.notifier;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfo;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfoInput;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NotifierService {

    private final List<Notifier> notifiers;

    public NotifierService(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void send(NotificationMessageInfoInput info) {
        Objects.requireNonNull(info);

        var notificationMessageInfo = new NotificationMessageInfo(info.message, info.subject);

        notifiers.stream()
                .filter(notifier -> info.targets.contains(notifier.getTarget()))
                .map(notifier -> new Thread(() -> notifier.send(notificationMessageInfo)))
                .forEach(Thread::start);
    }
}
