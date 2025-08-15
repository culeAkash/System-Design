package org.loggingframework.filters;

import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LogMessage;
import org.loggingframework.core.interfaces.LogFilter;
import org.loggingframework.filters.strategy.LogFilterStrategy;
import org.loggingframework.filters.strategy.LogLevelFilterStrategy;

public class LogLevelFilter extends LogFilterImpl {

    public LogLevelFilter(){
        super(new LogLevelFilterStrategy());
    }

    public LogLevelFilter(LogLevel level){
        super(level, new LogLevelFilterStrategy());
    }
}
