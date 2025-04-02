package LLD.ATMLowLevelDesign.ATMState.impl;

import LLD.ATMLowLevelDesign.ATMCard;
import LLD.ATMLowLevelDesign.ATMMachine;
import LLD.ATMLowLevelDesign.ATMState.ATMState;

public class ATMCardInsertedState extends ATMState {
    @Override
    public void authenticatePin(ATMMachine atmMachine,ATMCard atmCard,int atmPin){
        boolean isPinCorrect = atmCard.isCardPinCorrect(atmPin);

        if(isPinCorrect){
            System.out.println("Authentication successful, please select the transaction type");
            atmMachine.currentATMState = new ATMSelectOperationState();
        }
        else{
            System.out.println("Authentication failed, please try again");
            exit(atmMachine);
        }
    }


    @Override
    public void exit(ATMMachine atmMachine) {
        atmMachine.currentATMState = new ATMIdleState();
        System.out.println("Process has ended");
        removeCard();
    }

    @Override
    public void removeCard() {
        System.out.println("Please remove your card");
    }
}
