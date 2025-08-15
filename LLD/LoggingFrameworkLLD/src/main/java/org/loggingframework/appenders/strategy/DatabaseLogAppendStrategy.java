package org.loggingframework.appenders.strategy;

import org.loggingframework.core.LogMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogAppendStrategy implements LogAppendStartegy{

    private String tableName;
    private Connection connection;
    private PreparedStatement insertStatement;

    public DatabaseLogAppendStrategy(String tableName) {
        this.tableName = tableName;
        this.connection = null;
    }

    @Override
    public void doAppend(LogMessage message, String formattedMessage) {
        try {
            insertStatement.setTimestamp(1, java.sql.Timestamp.from(message.getTimeStamp()));
            insertStatement.setString(2, message.getLevel().toString());
            insertStatement.setString(3, message.getMessage());
            insertStatement.setString(4, message.getSource());
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to write to database: " + e.getMessage());
        }
    }
}
