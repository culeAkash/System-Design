package LLD.PaymentGatewayLowLevelDesign.instrument;

public class InstrumentDTO {
    
    private int instrumentId;
    private int userId;
    private InstrumentType instrumentType;
    private String cardNumber;
    private String cvv;
    private String bankName;
    private String accountNumber;
    private String ifsc;

    public int getInstrumentId() {
        return instrumentId;
    }
    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public InstrumentType getInstrumentType() {
        return instrumentType;
    }
    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getIfsc() {
        return ifsc;
    }
    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

}
