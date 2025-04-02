package LLD.ATMLowLevelDesign.ATMState;

import LLD.ATMLowLevelDesign.ATMCard;
import LLD.ATMLowLevelDesign.ATMMachine;
import LLD.ATMLowLevelDesign.TransactionType;

public abstract class ATMState {
    public void insertCard(ATMMachine atmMachine,ATMCard atmCard){
        System.out.println("Please insert a valid card");
    }

    public void authenticatePin(ATMMachine atmMachine,ATMCard atmCard,int atmPin){
        System.out.println("Please enter a valid pin");
    }

    public void selectOperation(ATMMachine atmMachine,ATMCard atmCard,TransactionType transactionType){
        System.out.println("Please select a valid transaction type");
    }

    public void withdrawCash(ATMMachine atmMachine,ATMCard atmCard,int amount){
        System.out.println("Please withdraw a valid amount");
    }

    public void displayBalance(ATMMachine atmMachine,ATMCard atmCard){
        System.out.println("Please select a valid transaction type");
    }

    public void exit(ATMMachine atmMachine){
        System.out.println("Please select a valid transaction type");
    }

    public void removeCard(){
        System.out.println("Please select a valid transaction type");
    }
}
