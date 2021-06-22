package br.com.felixgilioli.releasenotifier.notifier.impl;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DiscordNotifierImplTest {

    @InjectMocks
    private DiscordNotifierImpl discordNotifier;

    @Test
    void shouldReturnDiscordWhenCallGetTarget() {
        var target = discordNotifier.getTarget();
        assertEquals(NotificationTarget.DISCORD, target);
    }
}
