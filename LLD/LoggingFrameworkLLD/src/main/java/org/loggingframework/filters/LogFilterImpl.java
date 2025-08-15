package org.loggingframework.filters;

import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LogMessage;
import org.loggingframework.core.interfaces.LogFilter;
import org.loggingframework.filters.strategy.LogFilterStrategy;

public class LogFilterImpl implements LogFilter {

    private LogLevel level;
    private final LogFilterStrategy strategy;

    public LogFilterImpl(LogFilterStrategy strategy){
        this(LogLevel.DEBUG,strategy);
    }

    public LogFilterImpl(LogLevel level,LogFilterStrategy strategy){
        this.level = level;
        this.strategy = strategy;
    }

    @Override
    public boolean shouldLog(LogMessage message) {
        return strategy.doShouldLog(message,level);
    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public LogLevel getLevel() {
        return level;
    }
}
