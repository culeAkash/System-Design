package domain;

import java.time.LocalDateTime;
import java.util.UUID;

import domain.Payment.PaymentStatus;

public class Receipt {
    private UUID id;
    private UUID paymentId;
    private LocalDateTime exitTime;
    private Double amountPaid;
    private PaymentStatus paymentStatus;

    public Receipt() {
    }

    public Receipt(UUID paymentId, Double amountPaid) {
        this.id = UUID.randomUUID();
        this.paymentId = paymentId;
        this.exitTime = LocalDateTime.now();
        this.amountPaid = amountPaid;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void markAsPaid() {
        this.paymentStatus = PaymentStatus.SUCCESS;
    }

    public Double getTotalFee() {
        return amountPaid;
    }

    @Override
    public String toString() {
        return "Receipt [id=" + id + ", paymentId=" + paymentId + ", exitTime=" + exitTime + ", amountPaid="
                + amountPaid + ", paymentStatus=" + paymentStatus + "]";
    }

}
