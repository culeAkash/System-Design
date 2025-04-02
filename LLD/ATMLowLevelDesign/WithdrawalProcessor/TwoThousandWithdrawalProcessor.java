package LLD.ATMLowLevelDesign.WithdrawalProcessor;

import LLD.ATMLowLevelDesign.ATMMachine;

public class TwoThousandWithdrawalProcessor extends WithdrawalProcessor {
    
    public TwoThousandWithdrawalProcessor() {
        super(new FiveHundredWithdrawalProcessor());
    }


    @Override
    public void processWithdrawal(ATMMachine atmMachine,int amount) {
        int noOfTwoThousandNotes = atmMachine.noOfTwoThousandNotes;

        int requiredNotes = amount / 2000;
        int remainingAmount = amount % 2000;

        if(requiredNotes <= noOfTwoThousandNotes){
            atmMachine.deductTwoThousandNotes(requiredNotes);
        }
        else{
            atmMachine.deductTwoThousandNotes(noOfTwoThousandNotes);
            remainingAmount = remainingAmount + ((requiredNotes - noOfTwoThousandNotes) * 2000);
        }

        if(remainingAmount > 0){
            super.processWithdrawal(atmMachine, remainingAmount);
        }
    }
}
