package LLD.PaymentGatewayLowLevelDesign.payment;

import java.util.List;

public class TransactionController {
    TransactionService transactionService;

    public TransactionController() {
        this.transactionService = new TransactionService();
    }

    public TransactionDTO makePayment(TransactionDTO transactionDTO) {
        return transactionService.makePayment(transactionDTO);
    }

    public List<TransactionDTO> getTransactionHistory(int userId){
        return transactionService.getTransactionHistory(userId);
    }


}
