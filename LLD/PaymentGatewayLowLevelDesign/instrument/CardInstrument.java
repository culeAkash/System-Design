package LLD.PaymentGatewayLowLevelDesign.instrument;

public class CardInstrument extends Instrument {
    private String cardNumber;
    private String cvvNumber;

    public CardInstrument() {}

    public CardInstrument(int instrumentId, int userId, InstrumentType instrumentType, String cardNumber, String cvvNumber) {
        super(instrumentId, userId, instrumentType);
        this.cardNumber = cardNumber;
        this.cvvNumber = cvvNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }
}
