package domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    private UUID id;
    private UUID vehicleId;
    private UUID slotId;
    private LocalDateTime entryTime;
    private Boolean isActive;

    public ParkingTicket() {
    }

    public ParkingTicket(UUID id, UUID vehicleId, UUID slotId, LocalDateTime entryTime, Boolean isActive) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.slotId = slotId;
        this.entryTime = entryTime;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive(){
        return isActive;
    }

    public void deactivateTicket(){
        isActive = false;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", slotId=" + slotId +
                ", entryTime=" + entryTime +
                ", isActive=" + isActive +
                '}';
    }

    
}
