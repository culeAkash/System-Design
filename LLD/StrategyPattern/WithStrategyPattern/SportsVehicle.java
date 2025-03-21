package LLD.StrategyPattern.WithStrategyPattern;

public class SportsVehicle extends Vehicle {
    
    public SportsVehicle() {
        super(new SpecialDriveStrategy());
    }
}
