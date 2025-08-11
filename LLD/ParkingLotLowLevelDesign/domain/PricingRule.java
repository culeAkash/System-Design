package domain;

import java.util.UUID;

import domain.Vehicle.VehicleType;

public class PricingRule {
    private UUID id;
    private VehicleType vehicleType;
    private Double dailyRate;
    private Double hourlyRate;

    public PricingRule() {
    }

    public PricingRule(UUID id, VehicleType vehicleType, Double flatRate, Double hourlyRate) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.dailyRate = flatRate;
        this.hourlyRate = hourlyRate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double flatRate) {
        this.dailyRate = flatRate;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "PricingRule [id=" + id + ", vehicleType=" + vehicleType + ", dailyRate=" + dailyRate + ", hourlyRate="
                + hourlyRate + "]";
    }

    
}
