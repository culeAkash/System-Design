package LLD.LoggerLowLevelDesign;

public class InfoLogProcessor extends LogProcessor{

    public InfoLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }

    @Override
    void process(Log log) {
        if(log.getLevel()==Level.INFO){
            System.out.println("In Level Info: " + log.getMessage());
        }
        else{
            super.process(log);
        }
    }
    
}
