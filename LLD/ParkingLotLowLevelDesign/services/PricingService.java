package services;

import java.util.Optional;

import domain.ParkingTicket;
import domain.PricingRule;
import domain.Vehicle.VehicleType;
import repositories.PricingRuleRepository;

public class PricingService {

    private final PricingRuleRepository pricingRuleRepository;

    public PricingService(PricingRuleRepository pricingRuleRepository) {
        this.pricingRuleRepository = pricingRuleRepository;
    }

    public PricingRule getPricingRule(VehicleType vehicletType) {
        return getPricingRulesPrivate(vehicletType);
    }

    private PricingRule getPricingRulesPrivate(VehicleType vehicleType) {
        System.out.println("[SERVICE] Getting pricing rules for vehicle type: " + vehicleType);

        Optional<PricingRule> prOptional = this.pricingRuleRepository.findByVehicleType(vehicleType);

        if (prOptional.isEmpty()) {
            throw new IllegalStateException("No pricing rule found for vehicle type: " + vehicleType);
        }

        System.out.println("[SERVICE] Pricing rules found for vehicle type: " + vehicleType);
        return prOptional.get();
    }

    public Double calculatePrice(ParkingTicket ticket) {
        System.out.println("[SERVICE] Calculating price for ticket: " + ticket.getId());
        // validate if the ticket is active or not
        if (!ticket.getIsActive()) {
            throw new IllegalStateException("Ticket is not active");
        }

        // get current time to calculate the duration
        Long currentTime = System.currentTimeMillis();

        Long initialTime = ticket.getTimeInMillis();

        Long duration = currentTime - initialTime;

        // Convert time to maximum days on which dailyRate will get applied
        Long maxDays = duration / (1000 * 60 * 60 * 24);

        // Omit the maxDays and then on the remaining hours apply the hourlyRate
        duration = duration % (1000 * 60 * 60 * 24);

        // Convert time to maximum hours on which hourlyRate will get applied
        Long maxHours = duration / (1000 * 60 * 60);

        Double price = 0.0;

        // Find vehicle Details from Vehicle ID in parking ticket
        VehicleType vehicleType = ticket.getVehicleType();

        PricingRule pricingRule = this.getPricingRulesPrivate(vehicleType);

        if (maxDays > 0) {
            price = maxDays * pricingRule.getDailyRate();
        }

        if (maxHours > 0) {
            price = price + maxHours * pricingRule.getHourlyRate();
        }

        System.out.println("[SERVICE] Calculated price for ticket: " + ticket.getId() + " is: " + price);
        return price;

    }

}
