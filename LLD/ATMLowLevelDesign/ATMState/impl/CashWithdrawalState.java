package LLD.ATMLowLevelDesign.ATMState.impl;

import LLD.ATMLowLevelDesign.ATMCard;
import LLD.ATMLowLevelDesign.ATMMachine;
import LLD.ATMLowLevelDesign.ATMState.ATMState;
import LLD.ATMLowLevelDesign.WithdrawalProcessor.TwoThousandWithdrawalProcessor;
import LLD.ATMLowLevelDesign.WithdrawalProcessor.WithdrawalProcessor;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState(){
        System.out.println("Cash withdrawal process started");
    }


    public void withdrawCash(ATMMachine atmMachine,ATMCard atmCard,int amount){
        // check if amount is valid
        if(amount % 100 != 0){
            System.out.println("Invalid amount");
            exit(atmMachine);
        }

        // check if amount exceeds the balance in bank and atm
        else if(amount > atmCard.getBalance()){
            System.out.println("Insufficient balance in bank");
            exit(atmMachine);
        }

        // check if amount exceeds the balance in atm
        else if(amount > atmMachine.balance){
            System.out.println("Insufficient balance in atm");
            exit(atmMachine);
        }
        else{


        // process the withdrawal
        WithdrawalProcessor withdrawalProcessor = new TwoThousandWithdrawalProcessor();
        withdrawalProcessor.processWithdrawal(atmMachine, amount);

        atmCard.deductBalance(amount);
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
