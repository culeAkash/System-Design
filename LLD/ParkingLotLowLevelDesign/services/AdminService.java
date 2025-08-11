package services;

import java.util.UUID;

import domain.Floor;
import domain.ParkingSlot;
import domain.PricingRule;
import domain.Vehicle.VehicleType;
import repositories.FloorRepository;
import repositories.ParkingSlotRepository;
import repositories.PricingRuleRepository;

public class AdminService {
    
    private final FloorRepository floorRepository;
    private final ParkingSlotRepository parkingSlotRepository;
    private final PricingRuleRepository pricingRuleRepository;

    public AdminService(FloorRepository floorRepository,ParkingSlotRepository parkingSlotRepository,PricingRuleRepository pricingRuleRepository) {
        this.floorRepository = floorRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.pricingRuleRepository = pricingRuleRepository;
        System.out.println("[SERVICE] AdminService Initialized");
    }

    public void initializeParkingLot(){
        // create 3 floors
       for(int i=0;i<3;i++){
        addFloorPrivate();
       }

       // add parking slots to ground floor
       addSlotsToFloorPrivate(0,VehicleType.MOTORCYCLE,30);
       addSlotsToFloorPrivate(0,VehicleType.CAR,20);
       addSlotsToFloorPrivate(0,VehicleType.EV,10);

       // add parking slots to 1st floor
       addSlotsToFloorPrivate(1,VehicleType.CAR,40);
       addSlotsToFloorPrivate(1,VehicleType.EV,10);

       // add parking slots to 2nd floor
       addSlotsToFloorPrivate(2,VehicleType.CAR,20);
       addSlotsToFloorPrivate(2,VehicleType.EV,30);

       // initialize default Pricing rules
       initializeDefaultPricingRules();

       System.out.println("[SERVICE] Parking lot initialization completed");
    }

    private void initializeDefaultPricingRules() {
        System.out.println("[REPOSITORY] Initializing default pricing rules");
        // add default Pricing Rule for motorcycle
        PricingRule bikeRule = new PricingRule(UUID.randomUUID(),VehicleType.MOTORCYCLE,20.0,2.0);
        pricingRuleRepository.save(bikeRule);

        // add default Pricing Rule for car
        PricingRule carRule = new PricingRule(UUID.randomUUID(),VehicleType.CAR,100.0,10.0);
        pricingRuleRepository.save(carRule);

        // add default Pricing Rule for EV
        PricingRule evRule = new PricingRule(UUID.randomUUID(),VehicleType.EV,50.0,5.0);
        pricingRuleRepository.save(evRule);
    }

    private void addSlotsToFloorPrivate(int floorNumber,VehicleType vehicleType,int count){
        System.out.println("[SERVICE] Adding " + count + " slots of type " + vehicleType + " to floor " + floorNumber);
        // first verify if the floor exists
        Floor floor = this.floorRepository.floorByFloorNumber(floorNumber).orElseThrow(
            () -> new IllegalStateException("Floor : " + floorNumber + " does not exist")
        );

        for(int i=0;i< count;i++){
            ParkingSlot parkingSlot = new ParkingSlot(UUID.randomUUID(), vehicleType, false, floorNumber);
            this.parkingSlotRepository.addParkingSlot(parkingSlot);
            floor.addParkingSlot(parkingSlot);
        }

        System.out.println("[SERVICE] Added " + count + " slots to floor " + floorNumber);
    }

    public void addSlotsToFloor(int floorNumber,VehicleType vehicleType,int count){
        addSlotsToFloorPrivate(floorNumber,vehicleType,count);
    }



    private void addFloorPrivate() {
        // get currMax floor
        int currMaxFloor = floorRepository.getMaxFloor();
        System.out.println("[SERVICE] Adding floor with number: " + (currMaxFloor+1));
        Floor floor = new Floor(UUID.randomUUID(),currMaxFloor+1);
        this.floorRepository.saveFloor(floor);
        System.out.println("[SERVICE] Floor added successfully: " + floor.getId());
    }

    public void addFloor(){
        addFloorPrivate();
    }


    public void addPricingRule(PricingRule pricingRule){
        System.out.println("[SERVICE] Adding new Pricing Rule for VehicleType: " + pricingRule.getVehicleType());
        this.pricingRuleRepository.save(pricingRule);
        System.out.println("[SERVICE] Pricing Rule added successfully: " + pricingRule.getId());
    }

    public void updatePricingRule(VehicleType vehicleType,Double dailyRate,Double hourlyRate){
        System.out.println("[SERVICE] Updating Pricing Rule for VehicleType: " + vehicleType);

        PricingRule pricingRule = this.pricingRuleRepository.findByVehicleType(vehicleType).orElseThrow(
            () -> new IllegalStateException("Pricing Rule for VehicleType: " + vehicleType + " does not exist")
        );
        
        pricingRule.setDailyRate(dailyRate);
        pricingRule.setHourlyRate(hourlyRate);
        this.pricingRuleRepository.update(pricingRule);
        System.out.println("[SERVICE] Pricing Rule updated successfully: " + pricingRule.getId());
    }

    public void updateHourlyRate(VehicleType vehicleType,Double hourlyRate){
        System.out.println("[SERVICE] Updating Hourly Pricing Rule for VehicleType: " + vehicleType);

        PricingRule pricingRule = this.pricingRuleRepository.findByVehicleType(vehicleType).orElseThrow(
            () -> new IllegalStateException("Pricing Rule for VehicleType: " + vehicleType + " does not exist")
        );

        pricingRule.setHourlyRate(hourlyRate);
        this.pricingRuleRepository.update(pricingRule);
        System.out.println("[SERVICE] Pricing Rule updated successfully: " + pricingRule.getId());
    }

    public void updateDailyRate(VehicleType vehicleType,Double dailyRate){
        System.out.println("[SERVICE] Updating Daily Pricing Rule for VehicleType: " + vehicleType);

        PricingRule pricingRule = this.pricingRuleRepository.findByVehicleType(vehicleType).orElseThrow(
            () -> new IllegalStateException("Pricing Rule for VehicleType: " + vehicleType + " does not exist")
        );
        
        pricingRule.setDailyRate(dailyRate);
        this.pricingRuleRepository.update(pricingRule);
        System.out.println("[SERVICE] Pricing Rule updated successfully: " + pricingRule.getId());
    }
    

    
    
    
}
