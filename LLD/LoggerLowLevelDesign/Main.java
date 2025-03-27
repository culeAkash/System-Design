package LLD.LoggerLowLevelDesign;

public class Main {
    public static void main(String[] args) {
        LogProcessor logger = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logger.process(new Log("Error", Level.ERROR));
        logger.process(new Log("Info", Level.INFO));
        logger.process(new Log("Debug", Level.DEBUG));
    }
}
