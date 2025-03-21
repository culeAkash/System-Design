package LLD.StrategyPattern.WithStrategyPattern;

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle();
        vehicle.getDriveStrategy().drive();

        Vehicle vehicle2 = new OffRoadVehicle();
        vehicle2.getDriveStrategy().drive();

        Vehicle vehicle3 = new PassengerVehicle();
        vehicle3.getDriveStrategy().drive();
    }
    
}
