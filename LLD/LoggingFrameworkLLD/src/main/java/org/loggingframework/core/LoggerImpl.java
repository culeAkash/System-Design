package org.loggingframework.core;

import org.loggingframework.appenders.ConsoleLogAppender;
import org.loggingframework.core.interfaces.LogAppender;
import org.loggingframework.core.interfaces.LogFilter;
import org.loggingframework.core.interfaces.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LoggerImpl implements Logger {
    private final String name;
    private LogLevel level;// Level of the env
    private final List<LogAppender> appenders;
    private final List<LogFilter> filters;

    public LoggerImpl(){
        this("DefaultLogger");
    }

    public LoggerImpl(String defaultLogger) {
        this(defaultLogger,true);
    }

    public LoggerImpl(String name,boolean defaultAppender){
        this.name = name;
        this.level = LogLevel.DEBUG;
        System.out.println("[LOGGER] Started LoggerImpl constructor");
        this.appenders = Collections.synchronizedList(new ArrayList<>());
        this.filters = Collections.synchronizedList(new ArrayList<>());

        if(defaultAppender){
            addAppender(new ConsoleLogAppender());
        }

        System.out.println("[LOGGER] Logger Initialized");
    }




    /**
     * Method to log messages of level debug
     * @param message : Message to be logged
     */
    @Override
    public synchronized void debug(String message) {
        this.log(message,LogLevel.DEBUG);
    }

    /**
     * Method to log messages of level info
     * @param message : Message to be logged
     */
    @Override
    public synchronized void info(String message) {
        this.log(message,LogLevel.INFO);
    }

    /**
     * Method to log messages of level error
     * @param message : Message to be logged
     */
    @Override
    public synchronized void error(String message) {
        this.log(message,LogLevel.ERROR);
    }


    /**
     * Method to log messages of level fatal
     * @param message : Message to be logged
     */
    @Override
    public synchronized void fatal(String message) {
        this.log(message,LogLevel.FATAL);
    }


    /**
     * Method to log messages of level warning
     * @param message : Message to be logged
     */
    @Override
    public synchronized void warning(String message) {
        this.log(message,LogLevel.WARNING);
    }

    /**
     * Generic method to log messages from Application
     * @param message
     * @param level
     */
    @Override
    public synchronized void log(String message, LogLevel level) {
        // Check if log level of the message is equal or greater than the system log level
        if(!level.isPriorityGreaterOrEqual(this.level)){
            return;
        }


        // Create LogMessage by using the details passed by the application
        LogMessage logMessage = new LogMessage.Builder()
                .message(message)
                .level(level)
                .source(getCallingClass())
                .build();

        System.out.println("[LOGMESSAGE] : " + logMessage);

        // Apply filters
        AtomicInteger flag = new AtomicInteger(1);
        this.filters.stream().forEach(filter->{
            if(!filter.shouldLog(logMessage))
                flag.set(0);
        });
        System.out.println("[Log Filter] : " + flag.get());
        if(flag.get() == 0){
            return;
        }

        // Send to all appenders
        appenders.stream()
                .filter(appender->appender.isEnabled(logMessage.getLevel()))
                .forEach(appender -> appender.append(logMessage));

    }

    @Override
    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return level;
    }

    @Override
    public void addAppender(LogAppender appender) {
        this.appenders.add(appender);
    }

    @Override
    public void addFilter(LogFilter filter) {
        this.filters.add(filter);
    }

    @Override
    public void removeFilter(LogFilter filter) {
        this.filters.remove(filter);
    }

    @Override
    public List<LogAppender> getAppenders() {
        return this.appenders;
    }

    @Override
    public List<LogFilter> getFilters() {
        return this.filters;
    }


    /**
     * Gets the calling class name for source information.
     * This is a simplified implementation.
     */
    private String getCallingClass() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length > 3) {
                String className = stackTrace[3].getClassName();
                String methodName = stackTrace[3].getMethodName();
                return className + "." + methodName;
            }
        } catch (Exception e) {
            // Ignore exceptions in source detection
        }
        return "Unknown";
    }
}
