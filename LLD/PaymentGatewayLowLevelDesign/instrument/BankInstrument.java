package LLD.PaymentGatewayLowLevelDesign.instrument;

public class BankInstrument extends Instrument {
    private String bankName;
    private String accountNumber;
    private String ifscCode;

    public BankInstrument() {}

    public BankInstrument(int instrumentId, int userId, InstrumentType instrumentType, String bankName, String accountNumber, String ifscCode) {
        super(instrumentId, userId, instrumentType);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
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

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}
