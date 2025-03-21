package LLD.StrategyPattern.WithStrategyPattern;

public class SpecialDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Special vehicle is driving");
    }
    
}
