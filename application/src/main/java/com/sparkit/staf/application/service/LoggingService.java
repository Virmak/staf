package com.sparkit.staf.application.service;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.sparkit.staf.core.logger.LogObserver;
import com.sparkit.staf.core.logger.SubscriptionAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoggingService implements LogObserver {
    private static final String WS_MESSAGE_TRANSFER_DESTINATION = "/staf/logs";
    private final SimpMessagingTemplate simpleMessageTemplate;

    @Autowired
    public LoggingService(SimpMessagingTemplate simpleMessageTemplate) {
        this.simpleMessageTemplate = simpleMessageTemplate;
        SubscriptionAppender.getInstance().subscribe(this);
    }

    @Override
    public void update(ILoggingEvent event) {
        simpleMessageTemplate.convertAndSend(WS_MESSAGE_TRANSFER_DESTINATION, event.toString());
    }
}
