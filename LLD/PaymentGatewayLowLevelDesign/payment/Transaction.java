package LLD.PaymentGatewayLowLevelDesign.payment;

public class Transaction {
    private int transactionId;
    private TransactionStatus transactionStatus;
    private double amount;
    private int senderId;
    private int receiverId;
    private int creditInstrumentId;
    private int debitInstrumentId;


    public Transaction(int transactionId, TransactionStatus transactionStatus, double amount, int senderId, int receiverId, int creditInstrumentId, int debitInstrumentId) {
        this.transactionId = transactionId;
        this.transactionStatus = transactionStatus;
        this.amount = amount;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.creditInstrumentId = creditInstrumentId;
        this.debitInstrumentId = debitInstrumentId;
    }

    public Transaction() {}

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }   

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getSenderId() { 
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getCreditInstrumentId() {
        return creditInstrumentId;
    }

    public void setCreditInstrumentId(int creditInstrumentId) {
        this.creditInstrumentId = creditInstrumentId;
    }

    public int getDebitInstrumentId() {
        return debitInstrumentId;
    }

    public void setDebitInstrumentId(int debitInstrumentId) {
        this.debitInstrumentId = debitInstrumentId;
    }
}
