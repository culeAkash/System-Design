package services;

import java.util.UUID;

import adaptors.PaymentGatewayAdaptor;
import adaptors.RazorPayGatewayAdaptor;
import adaptors.StripeAdaptor;
import domain.Payment;
import domain.Payment.PaymentGateway;
import repositories.PaymentRepository;

public class PaymentService {
    private final PaymentRepository paymentRepository;
    private PaymentGatewayAdaptor gatewayAdaptor;

    public PaymentService(PaymentRepository paymentRepository, PaymentGatewayAdaptor gatewayAdaptor) {
        this.paymentRepository = paymentRepository;
        this.gatewayAdaptor = gatewayAdaptor != null ? gatewayAdaptor : RazorPayGatewayAdaptor.getInstance();
    }

    public boolean processPayment(UUID ticketId, double amount) {
        System.out.println("[SERVICE] Processing payment for ticket: " + ticketId + " amount: " + amount);

        Payment payment = new Payment(ticketId, amount, PaymentGateway.RAZORPAY);
        this.paymentRepository.createPayment(payment);

        boolean paymentProcessed = this.gatewayAdaptor.pay(ticketId, amount);

        if (paymentProcessed) {
            payment.markAsPaid();
        } else {
            payment.markAsFailed();
        }
        this.paymentRepository.updatePayment(payment);

        System.out.println("[SERVICE] Payment processed with status: " + (paymentProcessed ? "SUCCESS" : "FAILED"));

        return paymentProcessed;
    }

    public boolean processPaymentWithRetries(UUID ticketId, double amount, int maxRetries) {
        System.out.println("[SERVICE] Processing payment with retry for ticket: " + ticketId);

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            System.out.println("[SERVICE] Payment attempt " + attempt + " of " + maxRetries);

            boolean success = processPayment(ticketId, amount);
            if (success) {
                System.out.println("[SERVICE] Payment successful on attempt " + attempt);
                return true;
            }

            // Try different gateway on retry
            if (attempt > 1) {
                // Singleton pattern can be used here to avoid creating multiple instances of
                // the same gateway.
                gatewayAdaptor = StripeAdaptor.getInstance();
                System.out.println("[SERVICE] Switching to Stripe gateway for retry");
            }
        }
        System.out.println("[SERVICE] Payment failed after " + maxRetries + " attempts");
        return false;
    }
}
