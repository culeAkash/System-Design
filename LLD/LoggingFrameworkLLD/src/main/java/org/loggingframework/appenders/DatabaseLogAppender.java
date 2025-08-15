package org.loggingframework.appenders;

import org.loggingframework.appenders.strategy.DatabaseLogAppendStrategy;
import org.loggingframework.core.LogLevel;
import org.loggingframework.core.interfaces.LogFormatter;

public class DatabaseLogAppender extends LogAppenderImpl {

    public DatabaseLogAppender(String tableName){
        super(new DatabaseLogAppendStrategy(tableName));
    }

    public DatabaseLogAppender(LogFormatter formatter,String tableName){
        super(formatter,new DatabaseLogAppendStrategy(tableName));
    }

    public DatabaseLogAppender(LogLevel level,LogFormatter formatter,String tableName){
        super(level,formatter,new DatabaseLogAppendStrategy(tableName));
    }
}
