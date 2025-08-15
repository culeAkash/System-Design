package org.loggingframework.filters.strategy;

import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LogMessage;

public class LogSourceFilterStrategy implements LogFilterStrategy{
    private final String sourcePattern;
    private final boolean include;// true to include matching sources, false to exclude


    public LogSourceFilterStrategy(String sourcePattern,boolean include){
        this.include = include;
        this.sourcePattern = sourcePattern;
    }

    @Override
    public boolean doShouldLog(LogMessage message, LogLevel level) {
        if (message.getSource() == null) {
            return !include; // If no source, exclude if we're including, include if we're excluding
        }

        boolean matches = message.getSource().contains(sourcePattern);
        return include ? matches : !matches;
    }
}
