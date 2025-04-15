package LLD.InventorySystemDesign;

public class Invoice {
    private int invoiceId;
    private int amountPaid;

    public Invoice(int invoiceId, int amountPaid) {
        this.invoiceId = invoiceId;
        this.amountPaid = amountPaid;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "Invoice [invoiceId=" + invoiceId + ", amountPaid=" + amountPaid + "]";
    }

    
}
