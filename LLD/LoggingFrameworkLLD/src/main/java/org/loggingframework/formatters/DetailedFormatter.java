package org.loggingframework.formatters;

import org.loggingframework.core.LogMessage;
import org.loggingframework.core.interfaces.LogFormatter;

import java.time.format.DateTimeFormatter;

public class DetailedFormatter implements LogFormatter {
    private String pattern;
    private String dateFormat;
    private DateTimeFormatter dateTimeFormatter;

    public DetailedFormatter() {
        this("[%LEVEL] %TIMESTAMP [%SOURCE] - %MESSAGE");
    }

    public DetailedFormatter(String pattern) {
        this.pattern = pattern;
        this.dateFormat = "yyyy-MM-dd HH:mm:ss";
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public String format(LogMessage message) {
        if (pattern == null || pattern.isEmpty()) {
            String source = message.getSource() != null ? message.getSource() : "Unknown";
            return String.format("[%s] %s [%s] - %s",
                    message.getLevel(),
                    message.getTimeStamp().toString(),
                    source,
                    message.getMessage());
        }

        String formatted = pattern
                .replace("%LEVEL", message.getLevel().toString())
                .replace("%TIMESTAMP", message.getTimeStamp().toString())
                .replace("%MESSAGE", message.getMessage())
                .replace("%SOURCE", message.getSource() != null ? message.getSource() : "Unknown");

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
