package LLD.PaymentGatewayLowLevelDesign.payment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import LLD.PaymentGatewayLowLevelDesign.instrument.InstrumentController;
import LLD.PaymentGatewayLowLevelDesign.instrument.InstrumentDTO;

public class TransactionService {
    public static Map<Integer,List<Transaction>> userVsTransactionMap = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        this.instrumentController = new InstrumentController();
        this.processor = new Processor();
    }

    public List<TransactionDTO> getTransactionHistory(int userId){
        List<Transaction> transactionDTOs = userVsTransactionMap.get(userId);
        List<TransactionDTO>  transactionDTOS = transactionDTOs.stream().map(transaction-> {
            return mapTransactionToDTO(transaction);
        }).collect(Collectors.toList());
        return transactionDTOS;
    }

    public TransactionDTO makePayment(TransactionDTO transactionDTO) {
        InstrumentDTO senderInstrument =instrumentController.getInstrument(transactionDTO.getSenderId(), transactionDTO.getDebitInstrumentId());
        InstrumentDTO receiverInstrument =instrumentController.getInstrument(transactionDTO.getReceiverId(), transactionDTO.getCreditInstrumentId());
        processor.makePayment(senderInstrument,receiverInstrument);

        Transaction txn = new Transaction();
        txn.setTransactionId(new Random().nextInt(100-10)+10);
        txn.setTransactionStatus(TransactionStatus.SUCCESS);
        txn.setAmount(transactionDTO.getAmount());
        txn.setSenderId(transactionDTO.getSenderId());
        txn.setReceiverId(transactionDTO.getReceiverId());
        txn.setCreditInstrumentId(transactionDTO.getCreditInstrumentId());
        txn.setDebitInstrumentId(transactionDTO.getDebitInstrumentId());
        
        List<Transaction> senderTxnList = userVsTransactionMap.get(transactionDTO.getSenderId());
        if(senderTxnList == null) {
            senderTxnList = new java.util.ArrayList<>();
            userVsTransactionMap.put(transactionDTO.getSenderId(), senderTxnList);
        }

        List<Transaction> receiverTxnList = userVsTransactionMap.get(transactionDTO.getReceiverId());
        if(receiverTxnList == null) {
            receiverTxnList = new java.util.ArrayList<>();
            userVsTransactionMap.put(transactionDTO.getReceiverId(), receiverTxnList);
        }
        senderTxnList.add(txn);
        receiverTxnList.add(txn);

        transactionDTO.setTransactionId(txn.getTransactionId());
        transactionDTO.setTransactionStatus(txn.getTransactionStatus());

        return transactionDTO;
    }

    private TransactionDTO mapTransactionToDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(transaction.getTransactionId());
        transactionDTO.setTransactionStatus(transaction.getTransactionStatus());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setSenderId(transaction.getSenderId());
        transactionDTO.setReceiverId(transaction.getReceiverId());
        transactionDTO.setCreditInstrumentId(transaction.getCreditInstrumentId());
        transactionDTO.setDebitInstrumentId(transaction.getDebitInstrumentId());


        return transactionDTO;
    }
}
