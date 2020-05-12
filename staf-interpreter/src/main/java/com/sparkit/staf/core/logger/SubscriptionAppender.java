package com.sparkit.staf.core.logger;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionAppender extends AppenderBase<ILoggingEvent> {
    private String prefix;
    private List<LogObserver> observers = new ArrayList<>();
    private static SubscriptionAppender instance;

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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
