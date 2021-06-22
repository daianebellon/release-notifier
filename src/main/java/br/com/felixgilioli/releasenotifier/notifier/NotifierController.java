package br.com.felixgilioli.releasenotifier.notifier;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/notifier")
public class NotifierController {

    private final NotifierService notifierService;

    public NotifierController(NotifierService notifierService) {
        this.notifierService = notifierService;
    }

    @PostMapping("/send")
    public void send(@Valid @RequestBody NotificationMessageInfo info) {
        notifierService.send(info);
    }
}
