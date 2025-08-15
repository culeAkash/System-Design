package org.loggingframework.filters.strategy;

import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LogMessage;

public interface LogFilterStrategy {

    public boolean doShouldLog(LogMessage logMessage, LogLevel level);
}
