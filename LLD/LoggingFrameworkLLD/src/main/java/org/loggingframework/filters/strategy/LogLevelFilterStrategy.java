package org.loggingframework.filters.strategy;

import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LogMessage;

public class LogLevelFilterStrategy implements LogFilterStrategy{

    @Override
    public boolean doShouldLog(LogMessage logMessage, LogLevel level) {
        return logMessage.getLevel().isPriorityGreaterOrEqual(level);
    }
}
