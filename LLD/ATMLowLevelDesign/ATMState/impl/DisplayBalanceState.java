package LLD.ATMLowLevelDesign.ATMState.impl;

import LLD.ATMLowLevelDesign.ATMCard;
import LLD.ATMLowLevelDesign.ATMMachine;
import LLD.ATMLowLevelDesign.ATMState.ATMState;

public class DisplayBalanceState extends ATMState {
    
    @Override
    public void displayBalance(ATMMachine atmMachine,ATMCard atmCard) {
        System.out.println("Your balance is "+atmCard.getBalance());
        exit(atmMachine);
    }

    @Override
    public void exit(ATMMachine atmMachine) {
        atmMachine.currentATMState = new ATMIdleState();
        System.out.println("Process ended!");
        removeCard();
    }

    @Override
    public void removeCard() {
        System.out.println("Please remove your card");
    }
}
