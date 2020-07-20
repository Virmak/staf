package com.sparkit.staf.core.logger;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionAppender extends AppenderBase<ILoggingEvent> {
    private static SubscriptionAppender instance;
    private final List<LogObserver> observers = new ArrayList<>();
    @Getter
    @Setter
    private String prefix;

    public SubscriptionAppender() {
        instance = this;
    }

    public static SubscriptionAppender getInstance() {
        return instance;
    }

    @Override
    protected void append(ILoggingEvent event) {
        publish(event);
    }

    public void subscribe(LogObserver observer) {
        observers.add(observer);
    }

    public void publish(ILoggingEvent event) {
        for (LogObserver observer : observers) {
            observer.update(event);
        }
    }
}
