package LLD.CarRentalLowLevelDesign;

import java.util.List;

import LLD.CarRentalLowLevelDesign.product.Vehicle;

public class VehicleManagementSystem {
    private List<Vehicle> vehicles;

    public VehicleManagementSystem(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    
}
