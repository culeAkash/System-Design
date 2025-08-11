package services;

import java.util.Optional;
import java.util.UUID;

import domain.ParkingTicket;
import domain.Vehicle;
import repositories.TicketRepository;

public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ParkingTicket createTicket(Vehicle vehicle, UUID slotId) {
        System.out.println("[SERVICE] Creating ticket for vehicle: " + vehicle.getLicensePlate());
        ParkingTicket ticket = new ParkingTicket(UUID.randomUUID(), vehicle.getId(), slotId, vehicle.getVehicleType());
        this.ticketRepository.createTicket(ticket);
        System.out.println("[SERVICE] Ticket created: " + ticket.getId());
        return ticket;
    }

    public Optional<ParkingTicket> getTicket(UUID ticketId) {
        System.out.println("[SERVICE] Retrieving Ticket: " + ticketId);
        return Optional.of(this.ticketRepository.getTicket(ticketId));
    }

    public void deactivateTicket(UUID ticketId) {
        System.out.println("[SERVICE] Deactivating Ticket: " + ticketId);
        this.ticketRepository.deactivateTicket(ticketId);
        System.out.println("[SERVICE] Ticket deactivated: " + ticketId);
    }
}
