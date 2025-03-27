package LLD.LoggerLowLevelDesign;

public class ErrorLogProcessor extends LogProcessor{

    public ErrorLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    @Override
    void process(Log log) {
        if(log.getLevel()==Level.ERROR){
            System.out.println("In Level Error: " + log.getMessage());
        }
        else{
            super.process(log);
        }
    }
    
}