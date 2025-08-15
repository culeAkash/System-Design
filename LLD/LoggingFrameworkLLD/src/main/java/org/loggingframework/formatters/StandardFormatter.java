package org.loggingframework.formatters;

import org.loggingframework.core.LogMessage;
import org.loggingframework.core.interfaces.LogFormatter;

import java.time.format.DateTimeFormatter;

public class StandardFormatter implements LogFormatter {
    private String pattern;
    private String dateFormat;
    // Business use can be implemented later
    private DateTimeFormatter dateTimeFormatter;

    public StandardFormatter() {
        this("[%LEVEL] %TIMESTAMP - %MESSAGE");
    }

    public StandardFormatter(String pattern) {
        this.pattern = pattern;
        this.dateFormat = "yyyy-MM-dd HH:mm:ss";
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public String format(LogMessage message) {
        if (pattern == null || pattern.isEmpty()) {
            return String.format("[%s] %s - %s",
                    message.getLevel(),
                    message.getTimeStamp().toString(),
                    message.getMessage());
        }

        String formatted = pattern
                .replace("%LEVEL", message.getLevel().toString())
                .replace("%TIMESTAMP", message.getTimeStamp().toString())
                .replace("%MESSAGE", message.getMessage())
                .replace("%SOURCE", message.getSource() != null ? message.getSource() : "");

        return formatted;
    }

    @Override
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
    }
}
