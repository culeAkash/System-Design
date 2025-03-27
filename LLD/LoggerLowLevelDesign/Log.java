package LLD.LoggerLowLevelDesign;

public class Log {
    private final String message;
    private final Level level;

    public Log(String message, Level level) {
        this.message = message;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public Level getLevel() {
        return level;
    }

}

enum Level {
    DEBUG,
    INFO,
    ERROR
}
