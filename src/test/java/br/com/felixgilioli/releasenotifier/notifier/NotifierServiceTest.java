package br.com.felixgilioli.releasenotifier.notifier;

import br.com.felixgilioli.releasenotifier.notifier.impl.DiscordNotifierImpl;
import br.com.felixgilioli.releasenotifier.notifier.impl.EmailNotifierImpl;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfo;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class NotifierServiceTest {

    private NotifierService notifierService;

    @Mock
    private EmailNotifierImpl emailNotifier;

    @Mock
    private DiscordNotifierImpl discordNotifier;

    @BeforeEach
    void setup() {
        notifierService = new NotifierService(List.of(emailNotifier, discordNotifier));
        when(emailNotifier.getTarget()).thenReturn(NotificationTarget.EMAIL);
        when(discordNotifier.getTarget()).thenReturn(NotificationTarget.DISCORD);
    }

    @Test
    void shouldThrowsNullPointerExceptionWhenInfoIsNull() {
        assertThrows(NullPointerException.class, () -> notifierService.send(null));

        verify(emailNotifier, never()).send(any());
        verify(discordNotifier, never()).send(any());
    }

    @Test
    void shouldNotSendNotificationWhenNotifierUnspecified() {
        var message = "message";
        var notificationMessageInfo = new NotificationMessageInfo(message, Set.of(NotificationTarget.SLACK));
        notifierService.send(notificationMessageInfo);

        verify(emailNotifier, never()).send(message);
        verify(discordNotifier, never()).send(message);
    }

    @Test
    void shouldSendNotificationWhenNotifierIsSpecified() {
        var message = "message";
        var notificationMessageInfo = new NotificationMessageInfo(message, Set.of(NotificationTarget.DISCORD));
        notifierService.send(notificationMessageInfo);

        verify(emailNotifier, never()).send(message);
        verify(discordNotifier).send(message);
    }
}
