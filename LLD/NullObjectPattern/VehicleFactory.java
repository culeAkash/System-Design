package LLD.NullObjectPattern;

public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType){ {
        switch (vehicleType) {
            case "CAR":
                return new Car();
            case "BIKE":
                return new Bike();
            default:
                return new NullVehicle();
        }
    }
        
    }
}