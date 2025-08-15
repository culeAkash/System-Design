package org.loggingframework.appenders;

import org.loggingframework.appenders.strategy.LogAppendStartegy;
import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LogMessage;
import org.loggingframework.core.interfaces.LogAppender;
import org.loggingframework.core.interfaces.LogFormatter;
import org.loggingframework.formatters.StandardFormatter;

public class LogAppenderImpl implements LogAppender {

    private LogLevel level;
    private LogFormatter formatter;
    private final LogAppendStartegy strategy;

    public LogAppenderImpl(LogAppendStartegy strategy){
        this(new StandardFormatter(), strategy);
    }

    public LogAppenderImpl(LogFormatter formatter,LogAppendStartegy strategy){
        this(LogLevel.DEBUG,formatter,strategy);
    }

    public LogAppenderImpl(LogLevel level,LogFormatter formatter,LogAppendStartegy strategy){
        this.level = level;
        this.strategy = strategy;
        this.formatter = formatter;
    }

    @Override
    public void append(LogMessage message) {
        if(!isEnabled(message.getLevel())){
            return;
        }
        String formattedMessage = this.formatter.format(message);
        strategy.doAppend(message,formattedMessage);
    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    @Override
    public LogLevel getLevel() {
        return this.level;
    }

    @Override
    public boolean isEnabled(LogLevel level) {
        return level.isPriorityGreaterOrEqual(this.level);
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LogFormatter getFormatter() {
        return formatter;
    }
}
