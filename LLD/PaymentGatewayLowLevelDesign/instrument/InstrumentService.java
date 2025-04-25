package LLD.PaymentGatewayLowLevelDesign.instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    static Map<Integer,List<Instrument>> instrumentMap = new HashMap<>();

    public abstract InstrumentDTO addInstrument(InstrumentDTO instrumentDTO);

    public abstract List<InstrumentDTO> getAllInstrumentsByUserId(int userId);
}
