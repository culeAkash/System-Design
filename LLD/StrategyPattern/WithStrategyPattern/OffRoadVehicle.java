package LLD.StrategyPattern.WithStrategyPattern;

public class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle() {
        super(new SpecialDriveStrategy());
    }
    
}
