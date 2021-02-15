package com.erpdhmit.kafka.formatter;

import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Formatter implementation that simply returns the logback message.
 */
public class MessageFormatter implements Formatter {

    public String format(ILoggingEvent event) {
        return event.getFormattedMessage();
    }

}
