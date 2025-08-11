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
        STRIPE, RAZORPAY, CASH
    }

    public Payment() {
    }

    public Payment(UUID ticketId, Double amount, PaymentGateway gateway) {
        this.id = UUID.randomUUID();
        this.ticketId = ticketId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
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

    public void markAsPaid() {
        this.status = PaymentStatus.SUCCESS;
    }

    public void markAsFailed() {
        this.status = PaymentStatus.FAILED;
    }

    @Override
    public String toString() {
        return "Payment [id=" + id + ", ticketId=" + ticketId + ", amount=" + amount + ", status=" + status
                + ", gateway=" + gateway + "]";
    }

}
