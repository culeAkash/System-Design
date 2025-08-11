package services;

import java.util.Optional;
import java.util.UUID;

import domain.ParkingSlot;
import domain.Vehicle.VehicleType;
import repositories.ParkingSlotRepository;

public class SlotService {
    private final ParkingSlotRepository slotRepository;

    public SlotService(ParkingSlotRepository SlotRepository) {
        this.slotRepository = SlotRepository;
    }

    public Optional<ParkingSlot> allocateParkingSlot(VehicleType vehicleType){
        System.out.println("[SERVICE] Allocating parking slot for vehicle of type: " + vehicleType);

        Optional<ParkingSlot> parkingSlot = this.slotRepository.allocateParkingSlot(vehicleType);

        if(parkingSlot.isPresent()){
            System.out.println("[SERVICE] Parking slot allocated successfully");
        }else{
            System.out.println("[SERVICE] No parking slot available for vehicle of type: " + vehicleType);
        }
        return parkingSlot;
    }

    public void releaseSlot(UUID slotId){
        System.out.println("[SERVICE] Releasing parking slot: " + slotId);
        this.slotRepository.releaseSlot(slotId);
        System.out.println("[SERVICE] Parking slot released successfully");
    }


    public long getAvailableSlotCount(VehicleType vehicleType){
        return this.slotRepository.getAvailableParkingSlots(vehicleType).size();
    }
}
