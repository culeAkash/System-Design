package org.loggingframework.appenders;

import org.loggingframework.appenders.strategy.ConsoleLogAppenderStrategy;
import org.loggingframework.core.LogLevel;
import org.loggingframework.core.interfaces.LogFormatter;

public class ConsoleLogAppender extends LogAppenderImpl {

    public ConsoleLogAppender(){
        super(new ConsoleLogAppenderStrategy());
    }

    public ConsoleLogAppender(LogFormatter formatter){
        super(formatter,new ConsoleLogAppenderStrategy());
    }

    public ConsoleLogAppender(LogLevel level,LogFormatter formatter){
        super(level,formatter,new ConsoleLogAppenderStrategy());
    }
}
