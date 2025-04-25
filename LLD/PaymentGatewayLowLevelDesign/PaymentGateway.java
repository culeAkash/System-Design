package LLD.PaymentGatewayLowLevelDesign;

import java.util.List;


import LLD.PaymentGatewayLowLevelDesign.instrument.InstrumentController;
import LLD.PaymentGatewayLowLevelDesign.instrument.InstrumentDTO;
import LLD.PaymentGatewayLowLevelDesign.instrument.InstrumentType;
import LLD.PaymentGatewayLowLevelDesign.payment.TransactionController;
import LLD.PaymentGatewayLowLevelDesign.payment.TransactionDTO;
import LLD.PaymentGatewayLowLevelDesign.user.UserController;
import LLD.PaymentGatewayLowLevelDesign.user.UserDTO;

public class PaymentGateway {
    public static void main(String[] args) {
        InstrumentController instrumentController = new InstrumentController();
        TransactionController transactionController = new TransactionController();
        UserController userController = new UserController();


        // add user 1
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setName("Akash");
        userDTO1.setMail("Yp8d8@example.com");

        UserDTO user1Details = userController.addUser(userDTO1);

        // add user 2
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Dhruv");
        userDTO2.setMail("rY6bM@example.com");

        UserDTO user2Details = userController.addUser(userDTO2);

        // add bank to user 1
        InstrumentDTO bankInstrumentDTO = new InstrumentDTO();
        bankInstrumentDTO.setAccountNumber("1234567890");
        bankInstrumentDTO.setBankName("SBI");
        bankInstrumentDTO.setInstrumentType(InstrumentType.NET_BANKING);
        bankInstrumentDTO.setIfsc("SBI123");
        bankInstrumentDTO.setUserId(user1Details.getUserId());
        bankInstrumentDTO.setCvv("123");

        InstrumentDTO bankInstrument = instrumentController.addInstrument(bankInstrumentDTO);

        System.out.println("Bank Instrument created for user 1" + bankInstrument.getInstrumentId());


        // add card to user 2
        InstrumentDTO cardInstrumentDTO = new InstrumentDTO();
        cardInstrumentDTO.setAccountNumber("1234567890");
        cardInstrumentDTO.setBankName("SBI");
        cardInstrumentDTO.setInstrumentType(InstrumentType.CREDIT_CARD);
        cardInstrumentDTO.setIfsc("SBI123");
        cardInstrumentDTO.setUserId(user2Details.getUserId());
        cardInstrumentDTO.setCvv("123");

        InstrumentDTO cardInstrument = instrumentController.addInstrument(cardInstrumentDTO);

        System.out.println("Card Instrument created for user 2" + cardInstrument.getInstrumentId());

        // make payment
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(30);
        transactionDTO.setSenderId(user1Details.getUserId());
        transactionDTO.setReceiverId(user2Details.getUserId());
        transactionDTO.setCreditInstrumentId(bankInstrument.getInstrumentId());
        transactionDTO.setDebitInstrumentId(cardInstrument.getInstrumentId());
        transactionController.makePayment(transactionDTO);

        //get all instruments of user 1
        List<InstrumentDTO> user1InstrumentDTOs = instrumentController.getAllInstruments(user1Details.getUserId());
        for(InstrumentDTO instrumentDTO : user1InstrumentDTOs) {
            System.out.println(
                "User1 InstID: " + instrumentDTO.getInstrumentId() + 
                "UserId: " + instrumentDTO.getUserId() +
                "InstrumentType: " + instrumentDTO.getInstrumentType() 
            );
        }

        //get all instruments of user 2
        List<InstrumentDTO> user2InstrumentDTOs = instrumentController.getAllInstruments(user2Details.getUserId());
        for(InstrumentDTO instrumentDTO : user2InstrumentDTOs) {
            System.out.println(
                "User2 InstID: " + instrumentDTO.getInstrumentId() + 
                "UserId: " + instrumentDTO.getUserId() +
                "InstrumentType: " + instrumentDTO.getInstrumentType() 
            );
        }

        // get all transaction history
        List<TransactionDTO> user1TransactionDTOs = transactionController.getTransactionHistory(user1Details.getUserId());
        for(TransactionDTO transaction : user1TransactionDTOs) {
            System.out.println(
                "SenderID: " + transaction.getSenderId() + 
                "ReceiverID: " + transaction.getReceiverId() +
                "Amount: " + transaction.getAmount() 
            );
    }

}
}
