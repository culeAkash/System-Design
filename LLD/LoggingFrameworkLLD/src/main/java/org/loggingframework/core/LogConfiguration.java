package org.loggingframework.core;


// Configuration for the whole application


public class LogConfiguration {

    private LogLevel rootLevel;

    public LogConfiguration(){
        this.rootLevel = LogLevel.DEBUG;// default value
    }

    public LogConfiguration(LogLevel level){
        this.rootLevel = level;
    }

    public LogLevel getLevel() {
        return rootLevel;
    }

    public void setRootLevel(LogLevel level){
        this.rootLevel = level;
    }

    @Override
    public String toString() {
        return String.format("LogConfiguration{rootLevel=%s}", rootLevel);
    }
}
