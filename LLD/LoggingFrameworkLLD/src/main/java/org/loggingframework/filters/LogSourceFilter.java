package org.loggingframework.filters;

import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LogMessage;
import org.loggingframework.core.interfaces.LogFilter;
import org.loggingframework.core.interfaces.LogFormatter;
import org.loggingframework.filters.strategy.LogSourceFilterStrategy;

public class LogSourceFilter extends LogFilterImpl {

    public LogSourceFilter(String source,boolean include){
        super(new LogSourceFilterStrategy(source,include));
    }

    public LogSourceFilter(LogLevel level,String source, boolean include){
        super(level,new LogSourceFilterStrategy(source,include));
    }


}
