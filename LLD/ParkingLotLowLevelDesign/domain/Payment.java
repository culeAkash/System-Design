package domain;

import java.util.UUID;

public class Payment {
    private UUID id;
    private UUID ticketId;
    private Double amount;
    private PaymentStatus status;
    private PaymentGateway gateway;

    public enum PaymentStatus {
        PENDING, SUCCESS, FAILED
    }

    public enum PaymentGateway {
        STRIPE, PAYPAL, CASH
    }

    public Payment() {
    }

    public Payment(UUID id, UUID ticketId, Double amount, PaymentStatus status, PaymentGateway gateway) {
        this.id = id;
        this.ticketId = ticketId;
        this.amount = amount;
        this.status = status;
        this.gateway = gateway;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public PaymentGateway getGateway() {
        return gateway;
    }

    public void setGateway(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + ", ticketId=" + ticketId + ", amount=" + amount + ", status=" + status
                + ", gateway=" + gateway + "]";
    }

    
    
}
