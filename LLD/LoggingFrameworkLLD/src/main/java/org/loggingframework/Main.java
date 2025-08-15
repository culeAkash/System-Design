package org.loggingframework;

import org.loggingframework.appenders.ConsoleLogAppender;
import org.loggingframework.appenders.FileLogAppender;
import org.loggingframework.core.LogLevel;
import org.loggingframework.core.LoggerImpl;
import org.loggingframework.core.interfaces.LogAppender;
import org.loggingframework.core.interfaces.LogFilter;
import org.loggingframework.core.interfaces.LogFormatter;
import org.loggingframework.core.interfaces.Logger;
import org.loggingframework.filters.LogLevelFilter;
import org.loggingframework.formatters.StandardFormatter;

import java.util.logging.SimpleFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== LoggingFramework Demo ===\n");

        // Demo 1: Basic logging with different levels
         demoBasicLogging();

        // Demo 2: Multiple appenders
//        demoMultipleAppenders();

        // Demo 3: Custom formatters
//         demoCustomFormatters();

        // Demo 4: Filters
        // demoFilters();

        // Demo 5: Thread safety
//         demoThreadSafety();

        System.out.println("\n=== Demo Complete ===");
    }

    private static void demoBasicLogging() {
        System.out.println("1. Basic Logging Demo:");
        System.out.println("----------------------");

        Logger logger = new LoggerImpl("BasicLogger");

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

        System.out.println();
    }

    private static void demoMultipleAppenders() {
        System.out.println("2. Multiple Appenders Demo:");
        System.out.println("---------------------------");

        Logger logger = new LoggerImpl("MultiAppenderLogger");

        // Add file appender
        FileLogAppender fileAppender = new FileLogAppender("demo.log");
        logger.addAppender(fileAppender);

        logger.info("This message goes to both console and file");
        logger.error("This error also goes to both destinations");

        System.out.println("Check 'demo.log' file for the logged messages");
        System.out.println();
    }

    private static void demoCustomFormatters() {
        System.out.println("3. Custom Formatters Demo:");
        System.out.println("--------------------------");

        Logger logger = new LoggerImpl("FormatterLogger");

        // Create custom formatter
        LogFormatter customFormatter = new StandardFormatter("[%LEVEL] %TIMESTAMP - %MESSAGE");
        LogAppender consoleAppender = new ConsoleLogAppender();
        consoleAppender.setFormatter(customFormatter);

        // Replace default console appender
        logger.addAppender(consoleAppender);

        logger.info("This message uses custom formatting");
        logger.error("This error also uses custom formatting");

        System.out.println();
    }

    private static void demoFilters() {
        System.out.println("4. Filters Demo:");
        System.out.println("----------------");

        Logger logger = new LoggerImpl("FilterLogger");

        // Add level filter - only show WARNING and above
        LogFilter levelFilter = new LogLevelFilter(LogLevel.WARNING);
        logger.addFilter(levelFilter);

        logger.debug("This debug message will be filtered out");
        logger.info("This info message will be filtered out");
        logger.warning("This warning message will be shown");
        logger.error("This error message will be shown");

        System.out.println();
    }

    private static void demoThreadSafety() {
        System.out.println("5. Thread Safety Demo:");
        System.out.println("----------------------");

        Logger logger = new LoggerImpl("ThreadSafeLogger");

        // Create multiple threads logging simultaneously
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    logger.info("Thread " + threadId + " - Message " + j);
                    try {
                        Thread.sleep(10); // Small delay to increase concurrency
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All threads completed - check for any mixed-up messages above");
        System.out.println();
    }
}
