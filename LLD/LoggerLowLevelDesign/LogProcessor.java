package LLD.LoggerLowLevelDesign;

public abstract class LogProcessor {
    private LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor = nextLogProcessor;
    }

    void process(Log log){
        if(nextLogProcessor!=null){
            nextLogProcessor.process(log);
        }
        else{
            System.out.println("Log processed");
        }
    };

}