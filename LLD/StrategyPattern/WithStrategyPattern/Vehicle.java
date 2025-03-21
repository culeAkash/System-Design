package LLD.StrategyPattern.WithStrategyPattern;

public class Vehicle {
    private final DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
    
    public DriveStrategy getDriveStrategy() {
        return driveStrategy;
    }
}
