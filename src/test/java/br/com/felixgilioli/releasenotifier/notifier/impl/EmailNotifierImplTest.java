package br.com.felixgilioli.releasenotifier.notifier.impl;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailNotifierImplTest {

    @InjectMocks
    private EmailNotifierImpl emailNotifier;

    @Test
    void shouldReturnEmailWhenCallGetTarget() {
        var target = emailNotifier.getTarget();
        Assertions.assertEquals(NotificationTarget.EMAIL, target);
    }

}
