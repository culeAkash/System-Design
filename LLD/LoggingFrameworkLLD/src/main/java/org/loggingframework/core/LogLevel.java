package org.loggingframework.core;


//Represents the severity level of the Log Message
// Each level has a priority level for comparison


public enum LogLevel {
    DEBUG(1),
    INFO(2),
    ERROR(4),
    WARNING(3),
    FATAL(5);

    private final Integer priority;

    LogLevel(int priority){
        this.priority = priority;
    }

    public int getPriority(LogLevel level){
        return level.priority;
    }

    /**
     * Checks if this level is greater than or equal to the other level.
     * @param other The level to compare against
     * @return true if this level's priority >= other level's priority
     */
    public boolean isPriorityGreaterOrEqual(LogLevel other){
        return this.priority >= other.priority;
    }

}
