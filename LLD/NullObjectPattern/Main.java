package LLD.NullObjectPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.getVehicle("BIKE");

        System.out.println(vehicle1.getFuelDetails());
        System.out.println(vehicle1.getSeatDetails());
    }
}
