package LLD.ATMLowLevelDesign.WithdrawalProcessor;

import LLD.ATMLowLevelDesign.ATMMachine;

public class FiveHundredWithdrawalProcessor extends WithdrawalProcessor {
    public FiveHundredWithdrawalProcessor() {
        super(new OneHundredWithdrawalProcessor());
    }

    @Override
    public void processWithdrawal(ATMMachine atmMachine,int amount) {
        int noOfFiveHundredNotes = atmMachine.noOfFiveHundredNotes;

        int requiredNotes = amount / 500;
        int remainingAmount = amount % 500;

        if(requiredNotes <= noOfFiveHundredNotes){
            atmMachine.deductFiveHundredNotes(requiredNotes);
        }
        else{
            atmMachine.deductFiveHundredNotes(noOfFiveHundredNotes);
            remainingAmount = remainingAmount + ((requiredNotes - noOfFiveHundredNotes) * 500);
        }

        if(remainingAmount > 0){
            super.processWithdrawal(atmMachine, remainingAmount);
        }
    }
}
