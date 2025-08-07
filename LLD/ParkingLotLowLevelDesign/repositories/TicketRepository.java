package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import domain.ParkingTicket;

public class TicketRepository {
    Map<UUID,ParkingTicket> tickets = new ConcurrentHashMap<>();


    public ParkingTicket createTicket(ParkingTicket ticket){
        tickets.put(ticket.getId(),ticket);
        return ticket;
    }

    public boolean isTicketActive(UUID ticketId){
        if(!tickets.containsKey(ticketId)){
            throw new RuntimeException("Ticket not found");
        }
        return tickets.get(ticketId).getIsActive();
    }

    public ParkingTicket getTicket(UUID ticketId){
        if(!tickets.containsKey(ticketId)){
            throw new RuntimeException("Ticket not found");
        }
        return tickets.get(ticketId);
    }

    public List<ParkingTicket> getAllTickets(){
        return new ArrayList<>(tickets.values());
    }

    public List<ParkingTicket> getAllActiveTickets(){
        return tickets.values().stream()
            .filter(ParkingTicket::isActive)
            .collect(Collectors.toList());
    }

    public void deactivateTicket(UUID uuid){
        tickets.computeIfPresent(uuid,(id,ticket)->{
            ticket.deactivateTicket();;
            return ticket;
        });
    }

    public void clear(){
        tickets.clear();
    }
}
