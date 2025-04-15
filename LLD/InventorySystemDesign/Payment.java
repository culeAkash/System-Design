package LLD.InventorySystemDesign;

public class Payment {
    private int paymentId;
    private int amountPaid;
    private PaymentMode paymentMode;

    public Payment(int paymentId, int amountPaid, PaymentMode paymentMode) {
        this.paymentId = paymentId;
        this.amountPaid = amountPaid;
        this.paymentMode = paymentMode;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", amountPaid=" + amountPaid + ", paymentMode=" + paymentMode + "]";
    }

    



}
