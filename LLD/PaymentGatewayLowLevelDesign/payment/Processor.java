package LLD.PaymentGatewayLowLevelDesign.payment;


import LLD.PaymentGatewayLowLevelDesign.instrument.InstrumentDTO;

public class Processor {
    public void makePayment(InstrumentDTO senderInstrument,InstrumentDTO receiverInstrument){
        System.out.println("Payment made successfully");
    }
}
