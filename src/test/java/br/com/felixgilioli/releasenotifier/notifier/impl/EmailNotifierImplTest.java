package br.com.felixgilioli.releasenotifier.notifier.impl;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class EmailNotifierImplTest {

    @InjectMocks
    private EmailNotifierImpl emailNotifier;

    @Test
    void shouldReturnEmailWhenCallGetTarget() {
        var target = emailNotifier.getTarget();
        Assertions.assertEquals(NotificationTarget.EMAIL, target);
    }

}
