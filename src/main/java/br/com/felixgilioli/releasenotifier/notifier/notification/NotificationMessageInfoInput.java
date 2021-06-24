package br.com.felixgilioli.releasenotifier.notifier.notification;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class NotificationMessageInfoInput {

        @NotBlank(message = "message may not be blank")
        public String message;

        @NotBlank(message = "subject may not be blank")
        public String subject;

        @NotEmpty(message = "targets may not be empty")
        public Set<NotificationTarget> targets;

        public NotificationMessageInfoInput() {
        }

        public NotificationMessageInfoInput(String message, String subject, Set<NotificationTarget> targets) {
                this.message = message;
                this.subject = subject;
                this.targets = targets;
        }
}
