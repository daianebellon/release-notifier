package br.com.felixgilioli.releasenotifier.notifier.notification;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public record NotificationMessageInfo(

        @NotBlank(message = "message may not be blank")
        String message,

        @NotEmpty(message = "targets may not be empty")
        Set<NotificationTarget> targets
) {
}
