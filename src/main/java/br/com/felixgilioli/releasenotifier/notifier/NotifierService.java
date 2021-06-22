package br.com.felixgilioli.releasenotifier.notifier;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class NotifierService {

    private final List<Notifier> notifiers;

    public NotifierService(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void send(NotificationMessageInfo info) {
        Objects.requireNonNull(info);

        notifiers.stream()
                .filter(notifier -> info.targets().contains(notifier.getTarget()))
                .parallel()
                .forEach(notifier -> notifier.send(info.message()));
    }
}
