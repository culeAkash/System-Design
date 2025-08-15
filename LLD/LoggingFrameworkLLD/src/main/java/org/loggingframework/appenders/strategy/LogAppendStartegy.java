package org.loggingframework.appenders.strategy;

import org.loggingframework.core.LogMessage;

public interface LogAppendStartegy {
    public void doAppend(LogMessage message, String formattedMessage);
}
