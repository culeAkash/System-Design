package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import domain.ParkingSlot;
import domain.Vehicle.VehicleType;

public class ParkingSlotRepository {
    private Map<UUID,ParkingSlot> parkingSlots = new ConcurrentHashMap<>();
    

    public ParkingSlot addParkingSlot(ParkingSlot parkingSlot) {
        return parkingSlots.put(parkingSlot.getId(), parkingSlot);
    }

    public List<ParkingSlot> getAllSlots(){
        return new ArrayList<>(parkingSlots.values());
    }

    public List<ParkingSlot> getAvailableParkingSlots(VehicleType vehicleType){
        return parkingSlots.values().stream().filter((slot)->slot.getVehicleType() == vehicleType && !slot.isOccupied()).collect(Collectors.toList());
    }

    public Optional<ParkingSlot> allocateParkingSlot(VehicleType vehicleType){
        Optional<ParkingSlot> slot = parkingSlots.values().stream()
        .filter((slot2)->
            slot2.getVehicleType() == vehicleType && !slot2.isOccupied()
        ).findFirst()
        .map((slot1)->{
            slot1.setOccupied(true);
            return slot1;
        });
        return slot;
    }

    public void releaseSlot(UUID slotId){
        parkingSlots.computeIfPresent(slotId, (id,slot)->{
            slot.setOccupied(false);
            return slot;
        });
    }

    public void clear(){
        parkingSlots.clear();
    }
}
