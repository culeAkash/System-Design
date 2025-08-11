package ParkingLotLowLevelDesign;

import domain.ParkingSlot;
import repositories.FloorRepository;
import repositories.ParkingSlotRepository;
import repositories.PaymentRepository;
import repositories.PricingRuleRepository;
import repositories.TicketRepository;
import services.AdminService;
import services.PaymentService;
import services.PricingService;
import services.ReceiptService;
import services.SlotService;
import services.TicketService;

public class ParkingLotSimulation {

    // Repositories

    // Services

    // Controller

    public static void main(String[] args) {
        System.out.println("=== PARKING LOT LLD SIMULATION ===");
        System.out.println("This simulation demonstrates the complete parking lot system flow\n");

        // Initialize repositories
        TicketRepository ticketRepository = new TicketRepository();
        ParkingSlotRepository slotRepository = new ParkingSlotRepository();
        FloorRepository floorRepository = new FloorRepository();
        PricingRuleRepository pricingRuleRepository = new PricingRuleRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        // Initialize services
        TicketService ticketService = new TicketService(ticketRepository);
        SlotService slotService = new SlotService(slotRepository);
        PricingService pricingService = new PricingService(pricingRuleRepository);
        PaymentService paymentService = new PaymentService(paymentRepository, null);
        ReceiptService receiptService = new ReceiptService();
        AdminService adminService = new AdminService(floorRepository, slotRepository, pricingRuleRepository);

        // Initialize controllers
        EntryController entryController = new EntryController(ticketService, slotService);
        ExitController exitController = new ExitController(ticketService, pricingService, paymentService,
                receiptService, slotService);
        AdminController adminController = new AdminController(adminService);
    }
}