package org.loggingframework.appenders.strategy;

import org.loggingframework.core.LogMessage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogAppendStrategy implements LogAppendStartegy{

    private String filePath;
    private PrintWriter writer;

    public FileLogAppendStrategy(String filePath) {
        this.filePath = filePath;
        initializeWriter();
    }

    private void initializeWriter() {
        try {
            this.writer = new PrintWriter(new FileWriter(filePath, true), true);
        } catch (IOException e) {
            System.err.println("Failed to initialize FileAppender for " + filePath + ": " + e.getMessage());
        }
    }

    @Override
    public void doAppend(LogMessage message, String formattedMessage) {
        try {
            writer.println(formattedMessage);
            writer.flush();
        } catch (Exception e) {
            System.err.println("Failed to write to file " + filePath + ": " + e.getMessage());
        }
    }
}
