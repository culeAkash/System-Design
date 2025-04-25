package LLD.PaymentGatewayLowLevelDesign.instrument;

import java.util.List;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;
    public InstrumentController() {
        this.instrumentServiceFactory = new InstrumentServiceFactory();
    }

    public InstrumentDTO addInstrument(InstrumentDTO instrument) {
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrument.getInstrumentType());
        return instrumentService.addInstrument(instrument);
    }

    public List<InstrumentDTO> getAllInstruments(int userId){
        InstrumentService bankInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.NET_BANKING);
        InstrumentService cardInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.CREDIT_CARD);
        List<InstrumentDTO> bankInstrumentDTOs = bankInstrumentService.getAllInstrumentsByUserId(userId);
        List<InstrumentDTO> cardInstrumentDTOs = cardInstrumentService.getAllInstrumentsByUserId(userId);
        bankInstrumentDTOs.addAll(cardInstrumentDTOs);
        return bankInstrumentDTOs;
    }

    public InstrumentDTO getInstrument(int userId, int instrumentId) {
        List<InstrumentDTO> allInstruments = getAllInstruments(userId);
        InstrumentDTO instrumentDto = allInstruments.stream().filter(instrument-> instrument.getUserId()== userId && instrument.getInstrumentId() == instrumentId).findFirst().orElse(null);
        return instrumentDto;
    }
}
