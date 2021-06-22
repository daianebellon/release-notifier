package br.com.felixgilioli.releasenotifier.notifier.notification;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class NotificationMessageInfo {

        @NotBlank(message = "message may not be blank")
        public String message;

        @NotEmpty(message = "targets may not be empty")
        public Set<NotificationTarget> targets;

        public NotificationMessageInfo() {
        }

        public NotificationMessageInfo(String message, Set<NotificationTarget> targets) {
                this.message = message;
                this.targets = targets;
        }
}
