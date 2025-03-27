package LLD.CarRentalLowLevelDesign;

import java.util.Date;

public class Payment {
    Bill bill;
    PaymentDetails paymentDetails;

    public void payBill(Bill bill,PaymentMode paymentMode){ 
        this.bill = bill;
        this.paymentDetails = new PaymentDetails();
        this.paymentDetails.paymentMode = paymentMode;
        this.paymentDetails.amountPaid = bill.totalBillAmount;
        this.paymentDetails.dateOfPayment = new Date();
        System.out.println("Payment Successful");
    }
}
