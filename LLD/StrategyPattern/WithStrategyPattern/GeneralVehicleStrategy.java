package LLD.StrategyPattern.WithStrategyPattern;

public class GeneralVehicleStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("General vehicle is driving");
    }
    
}
