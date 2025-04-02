package LLD.ATMLowLevelDesign.ATMState.impl;

import LLD.ATMLowLevelDesign.ATMCard;
import LLD.ATMLowLevelDesign.ATMMachine;
import LLD.ATMLowLevelDesign.ATMState.ATMState;

public class ATMIdleState extends ATMState {
    
    @Override
    public void insertCard(ATMMachine atmMachine,ATMCard atmCard) {
        System.out.println("ATM card is inserted");
        atmMachine.currentATMState = new ATMCardInsertedState();
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
