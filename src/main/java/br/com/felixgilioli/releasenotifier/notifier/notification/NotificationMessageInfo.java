package br.com.felixgilioli.releasenotifier.notifier.notification;

import java.util.Objects;

public class NotificationMessageInfo {

    private final String message;
    private final String subject;

    public NotificationMessageInfo(String message, String subject) {
        this.message = Objects.requireNonNull(message);
        this.subject = Objects.requireNonNull(subject);
    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationMessageInfo that = (NotificationMessageInfo) o;
        return message.equals(that.message) && subject.equals(that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, subject);
    }
}
