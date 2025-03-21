package LLD.StrategyPattern.WithStrategyPattern;

public class PassengerVehicle extends Vehicle{ 
    public PassengerVehicle() {
        super(new GeneralVehicleStrategy());
    }
}
