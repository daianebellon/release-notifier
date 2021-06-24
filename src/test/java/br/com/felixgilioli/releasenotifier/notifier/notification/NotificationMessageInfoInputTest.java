package br.com.felixgilioli.releasenotifier.notifier.notification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class NotificationMessageInfoInputTest {

    @Test
    void constructorWithAllArgs() {
        var message = "test message";
        var subject = "Alert";
        var targets = Set.of(NotificationTarget.EMAIL);

        var input = new NotificationMessageInfoInput(message, subject, targets);

        Assertions.assertEquals(message, input.message);
        Assertions.assertEquals(subject, input.subject);
        Assertions.assertEquals(targets, input.targets);
    }
}
