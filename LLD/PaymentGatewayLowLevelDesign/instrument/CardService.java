package LLD.PaymentGatewayLowLevelDesign.instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService {

    @Override
    public InstrumentDTO addInstrument(InstrumentDTO instrumentDTO) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.setInstrumentId(new Random().nextInt(100-10)+10);;
        bankInstrument.setAccountNumber(instrumentDTO.getAccountNumber());
        bankInstrument.setIfscCode(instrumentDTO.getIfsc());
        bankInstrument.setBankName(instrumentDTO.getBankName());
        bankInstrument.setInstrumentType(InstrumentType.CREDIT_CARD);
        bankInstrument.setUserId(instrumentDTO.getUserId());
        List<Instrument> instrumentList = instrumentMap.get(instrumentDTO.getUserId());
        if(instrumentList == null) {
            instrumentList = new ArrayList<>();
            instrumentMap.put(instrumentDTO.getUserId(), instrumentList);
        }
        instrumentList.add(bankInstrument);
        return mapBankInstrumentToDTO(bankInstrument);
    }

    private InstrumentDTO mapBankInstrumentToDTO(BankInstrument bankInstrument) {
        InstrumentDTO instrumentDTO = new InstrumentDTO();
        instrumentDTO.setInstrumentId(bankInstrument.getInstrumentId());
        instrumentDTO.setUserId(bankInstrument.getUserId());
        instrumentDTO.setInstrumentType(bankInstrument.getInstrumentType());
        instrumentDTO.setBankName(bankInstrument.getBankName());
        instrumentDTO.setAccountNumber(bankInstrument.getAccountNumber());
        instrumentDTO.setIfsc(bankInstrument.getIfscCode());
        return instrumentDTO;
    }

    @Override
    public List<InstrumentDTO> getAllInstrumentsByUserId(int userId) {
        List<Instrument> instruments = instrumentMap.get(userId);
        List<InstrumentDTO> instrumentDTOs = new ArrayList<>();
        for(Instrument instrument : instruments) {
            instrumentDTOs.add(mapBankInstrumentToDTO((BankInstrument)instrument));
        }
        return instrumentDTOs;
    }
    
}
