package com.sparkit.staf.application.service;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.sparkit.staf.core.logging.LogObserver;
import com.sparkit.staf.core.logging.SubscriptionAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoggingService implements LogObserver {
    private static final String WS_MESSAGE_TRANSFER_DESTINATION = "/staf/logs";
    @Autowired
    private SimpMessagingTemplate simpleMessageTemplate;

    public LoggingService() {
        SubscriptionAppender.getInstance().subscribe(this);
    }

    public void sendMessages() {
        simpleMessageTemplate.convertAndSend("Hello user");
    }

    @Override
    public void update(ILoggingEvent event) {
        simpleMessageTemplate.convertAndSend(WS_MESSAGE_TRANSFER_DESTINATION, event.toString());
    }
}
