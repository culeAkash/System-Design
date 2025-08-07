package domain;

import java.util.UUID;

public class ParkingSlot {
    private UUID id;
    private Vehicle.VehicleType vehicleType;
    private boolean isOccupied;
    private int floorNumber;

    public ParkingSlot() {
    }

    public ParkingSlot(UUID id, Vehicle.VehicleType vehicleType, boolean isOccupied, int floorNumber) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.isOccupied = isOccupied;
        this.floorNumber = floorNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Vehicle.VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Vehicle.VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", vehicleType=" + vehicleType +
                ", isOccupied=" + isOccupied +
                ", floorNumber=" + floorNumber +
                '}';
    }

    
}
