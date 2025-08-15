package org.loggingframework.core.interfaces;

import org.loggingframework.core.LogLevel;

import java.util.List;

public interface Logger {

    // Logging methods for different levels
    public void debug(String message);
    public void info(String message);
    public void error(String message);
    public void fatal(String message);
    public void warning(String message);

    // Logging method to pass message and level
    public void log(String message, LogLevel level);

    // Configuration Methods
    public void setLevel(LogLevel level);
    public void addAppender(LogAppender appender);
    public void addFilter(LogFilter filter);
    public void removeFilter(LogFilter filter);

    // Getter methods
    public List<LogAppender> getAppenders();
    public List<LogFilter> getFilters();
}
