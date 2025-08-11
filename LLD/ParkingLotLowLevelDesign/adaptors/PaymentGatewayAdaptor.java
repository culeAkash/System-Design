package adaptors;

import java.util.UUID;

public interface PaymentGatewayAdaptor {
    boolean pay(UUID ticketId, double amount);
}
