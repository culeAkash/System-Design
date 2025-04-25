package LLD.PaymentGatewayLowLevelDesign.instrument;

public class InstrumentServiceFactory {
    public InstrumentService getInstrumentService(InstrumentType instrumentType) {
        switch(instrumentType){
            case CREDIT_CARD:
                return new CardService();
            case NET_BANKING:
                return new BankService();
            default:
                return null;
        }
    }
}
