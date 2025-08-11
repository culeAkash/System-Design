package adaptors;

import java.util.Random;
import java.util.UUID;

public class RazorPayGatewayAdaptor implements PaymentGatewayAdaptor {

    // Singleton Design Pattern
    private static RazorPayGatewayAdaptor razorPayGatewayAdaptor;

    private RazorPayGatewayAdaptor() {
        razorPayGatewayAdaptor = new RazorPayGatewayAdaptor();
    }

    public static RazorPayGatewayAdaptor getInstance() {
        if (razorPayGatewayAdaptor == null) {
            return new RazorPayGatewayAdaptor();
        }
        return razorPayGatewayAdaptor;
    }

    @Override
    public boolean pay(UUID ticketId, double amount) {
        // Simulate payment processing
        System.out
                .println("[ADAPTER] RazorpayAdapter processing payment for ticket: " + ticketId + " amount: " + amount);

        // Simulate 90% success rate
        Random random = new Random();
        boolean success = random.nextDouble() < 0.9;

        System.out.println("[ADAPTER] RazorpayAdapter payment result: " + (success ? "SUCCESS" : "FAILED"));

        return success;
    }

}
