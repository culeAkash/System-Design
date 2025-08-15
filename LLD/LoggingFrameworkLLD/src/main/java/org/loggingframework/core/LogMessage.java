package org.loggingframework.core;

import java.time.Instant;


/*
    Using Builder Pattern here to create object so that we can create objects easily also when more props get inserted without adding more setters
 */


public class LogMessage {

    private final Instant timeStamp;
    private final String message;
    private final String source;
    private final LogLevel Level;


    public LogMessage(Builder builder){
        this.Level = builder.level;
        this.message = builder.message;
        this.source = builder.source;
        this.timeStamp = builder.timeStamp;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getSource() {
        return source;
    }

    public LogLevel getLevel() {
        return Level;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", source='" + source + '\'' +
                ", Level=" + Level +
                '}';
    }

    public static class Builder{
        private Instant timeStamp = Instant.now();;
        private String message;
        private String source;
        private LogLevel level;


        public Builder level(LogLevel level){
            this.level = level;
            return this;
        }

        public Builder timeStamp(Instant timeStamp){
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder source(String source){
            this.source = source;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public LogMessage build(){
            if(this.level == null){
                throw new IllegalStateException("LogLevel is required");
            }

            if(message==null || message.trim().isEmpty()){
                throw new IllegalStateException("Message is required");
            }

            return new LogMessage(this);
        }

    }

}
