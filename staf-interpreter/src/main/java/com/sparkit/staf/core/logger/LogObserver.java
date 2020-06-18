package com.sparkit.staf.core.logger;

import ch.qos.logback.classic.spi.ILoggingEvent;

public interface LogObserver {
    void update(ILoggingEvent event);
}
