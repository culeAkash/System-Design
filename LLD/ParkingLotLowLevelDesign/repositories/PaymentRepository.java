package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import domain.Payment;
import domain.Payment.PaymentStatus;

public class PaymentRepository {
    private Map<UUID,Payment> payments = new ConcurrentHashMap<>();
    private Map<UUID,List<UUID>> ticketToPayment = new ConcurrentHashMap<>();

    public Payment createPayment(Payment payment) {
        payments.put(payment.getId(), payment);
        ticketToPayment.computeIfAbsent(payment.getTicketId(), key->new ArrayList<>()).add(payment.getId());
        return payment;
    }

    public void updatePayment(Payment payment) {
        if(ticketToPayment.containsKey(payment.getTicketId()))
            payments.put(payment.getId(), payment);
    }

    public List<Payment> getAllPayments(){
        return new ArrayList<>(payments.values());
    }

    public List<Payment> getAllPaymentsOfTicket(UUID ticketId){
        return ticketToPayment.computeIfPresent(ticketId, (key,value)->value)
            .stream()
            .map(payments::get)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public PaymentStatus getPaymentStatus(UUID ticketId){
        Optional<Payment> payment = payments.values().stream()
            .filter((payment1)->payment1.getTicketId().equals(ticketId))
            .findFirst();
        return payment.isPresent() ? payment.get().getStatus() : PaymentStatus.PENDING;
            
    }

    public void deletePayment(UUID paymentId){
        Payment payment = payments.remove(paymentId);
        ticketToPayment.computeIfPresent(payment.getTicketId(),(key,value)->{
            value.stream()
            .filter((paymentID)->paymentID.equals(paymentId))
            .findFirst().ifPresent(value::remove);
            return value;
        });
    }

    
}
