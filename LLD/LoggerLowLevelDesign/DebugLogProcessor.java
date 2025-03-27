package LLD.LoggerLowLevelDesign;

public class DebugLogProcessor extends LogProcessor{

    public DebugLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    @Override
    void process(Log log) {
        if(log.getLevel()==Level.DEBUG){
            System.out.println("In Level Debug: " + log.getMessage());
        }
        else{
            super.process(log);
        }
    }
    
}
