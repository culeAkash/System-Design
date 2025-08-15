package org.loggingframework.appenders;

import org.loggingframework.appenders.strategy.FileLogAppendStrategy;
import org.loggingframework.core.LogLevel;
import org.loggingframework.core.interfaces.LogFormatter;

public class FileLogAppender extends LogAppenderImpl {

    public FileLogAppender(String filePath){
        super(new FileLogAppendStrategy(filePath));
    }

    public FileLogAppender(LogFormatter formatter,String filePath){
        super(formatter,new FileLogAppendStrategy(filePath));
    }

    public FileLogAppender(LogLevel level,LogFormatter formatter,String filePath){
        super(level,formatter,new FileLogAppendStrategy(filePath));
    }
}
