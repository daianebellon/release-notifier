package br.com.felixgilioli.releasenotifier.notifier;

import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationMessageInfoInput;
import br.com.felixgilioli.releasenotifier.notifier.notification.NotificationTarget;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Set;

import static br.com.felixgilioli.releasenotifier.JsonUtils.asJsonString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class NotifierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotifierService notifierService;

    @Test
    void givenNotificationWithNullMessageReturnsValidationError() throws Exception {
        var messageInfo = new NotificationMessageInfoInput(null, "test", Set.of(NotificationTarget.EMAIL));

        mockMvc.perform(post("/notifier/send")
                        .content(asJsonString(messageInfo))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));

        verify(notifierService, never()).send(messageInfo);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void givenNotificationWithBlankMessageReturnsValidationError(String value) throws Exception {
        var messageInfo = new NotificationMessageInfoInput(value, "test", Set.of(NotificationTarget.EMAIL));

        mockMvc.perform(post("/notifier/send")
                        .content(asJsonString(messageInfo))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));

        verify(notifierService, never()).send(messageInfo);
    }

    @Test
    void givenNotificationWithNullTargetsReturnsValidationError() throws Exception {
        var messageInfo = new NotificationMessageInfoInput("hello", "test", null);

        mockMvc.perform(post("/notifier/send")
                        .content(asJsonString(messageInfo))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));

        verify(notifierService, never()).send(messageInfo);
    }

    @Test
    void givenNotificationWithEmptyTargetsReturnsValidationError() throws Exception {
        var messageInfo = new NotificationMessageInfoInput("hello", "test", Collections.emptySet());

        mockMvc.perform(post("/notifier/send")
                        .content(asJsonString(messageInfo))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));

        verify(notifierService, never()).send(messageInfo);
    }

    @Test
    void givenValidNotificationReturnsStatusOk() throws Exception {
        var messageInfo = new NotificationMessageInfoInput("hello", "test", Set.of(NotificationTarget.EMAIL));

        doNothing().when(notifierService).send(messageInfo);

        mockMvc.perform(post("/notifier/send")
                        .content(asJsonString(messageInfo))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(notifierService).send(any());
    }

}
