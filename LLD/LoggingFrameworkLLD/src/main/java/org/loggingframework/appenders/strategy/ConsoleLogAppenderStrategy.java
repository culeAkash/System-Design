package org.loggingframework.appenders.strategy;

import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LogMessage;

import java.io.PrintStream;

public class ConsoleLogAppenderStrategy implements LogAppendStartegy{

    private final PrintStream printStream;

    public ConsoleLogAppenderStrategy(){
        printStream = System.out;
    }

    @Override
    public void doAppend(LogMessage message, String formattedMessage) {
        // Use System.err for ERROR and FATAL levels
        if (message.getLevel() == LogLevel.ERROR || message.getLevel() == LogLevel.FATAL) {
            System.err.println(formattedMessage);
        } else {
            printStream.println(formattedMessage);
        }
    }
}
