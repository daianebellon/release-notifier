package br.com.felixgilioli.releasenotifier.notifier.impl;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class DiscordNotifierImplTest {

    @InjectMocks
    private DiscordNotifierImpl discordNotifier;

    @Test
    void shouldReturnDiscordWhenCallGetTarget() {
        var target = discordNotifier.getTarget();
        assertEquals(NotificationTarget.DISCORD, target);
    }
}
