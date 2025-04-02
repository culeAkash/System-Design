package LLD.ATMLowLevelDesign.ATMState.impl;

import LLD.ATMLowLevelDesign.ATMCard;
import LLD.ATMLowLevelDesign.ATMMachine;
import LLD.ATMLowLevelDesign.TransactionType;
import LLD.ATMLowLevelDesign.ATMState.ATMState;

public class ATMSelectOperationState extends ATMState {
    public void selectOperation(ATMMachine atmMachine,ATMCard atmCard,TransactionType transactionType){
        switch (transactionType) {
            case CASHWiTHDRAWAL:
                atmMachine.currentATMState = new CashWithdrawalState();
                break;
            case DISPLAYBALANCE:
                atmMachine.currentATMState = new DisplayBalanceState();
                break;
            default:
                exit(atmMachine);
                break;
        }
    }

    @Override
    public void exit(ATMMachine atmMachine) {
        atmMachine.currentATMState = new ATMIdleState();
        System.out.println("Invalid operation, process failed!");
        removeCard();
    }

    @Override
    public void removeCard() {
        System.out.println("Please remove your card");
    }
}
