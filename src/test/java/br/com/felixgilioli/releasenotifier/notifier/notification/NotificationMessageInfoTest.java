package br.com.felixgilioli.releasenotifier.notifier.notification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NotificationMessageInfoTest {

    @Test
    void constructorWithMessageNull() {
        assertThrows(NullPointerException.class, () -> new NotificationMessageInfo(null, "test"));
    }

    @Test
    void constructorWithSubjectNull() {
        assertThrows(NullPointerException.class, () -> new NotificationMessageInfo("test", null));
    }

    @Test
    void constructorWithAllArgsConstruct() {
        var message = "test";
        var subject = "subject";

        var messageInfo = new NotificationMessageInfo(message, subject);

        assertEquals(message, messageInfo.getMessage());
        assertEquals(subject, messageInfo.getSubject());
    }
}
