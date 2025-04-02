package LLD.ATMLowLevelDesign.WithdrawalProcessor;

import LLD.ATMLowLevelDesign.ATMMachine;

public class OneHundredWithdrawalProcessor extends WithdrawalProcessor {
    
    public OneHundredWithdrawalProcessor() {
        super(null);
    }

    @Override
    public void processWithdrawal(ATMMachine atmMachine,int amount) {
        int noOfOneHundredNotes = atmMachine.noOfOneHundredNotes;

        int requiredNotes = amount / 100;
        int remainingAmount = amount % 100; 

        if(requiredNotes <= noOfOneHundredNotes){
            atmMachine.deductOneHundredNotes(requiredNotes);
        }
        else{
            atmMachine.deductOneHundredNotes(noOfOneHundredNotes);
            remainingAmount = remainingAmount + ((requiredNotes - noOfOneHundredNotes) * 100);
        }

        if(remainingAmount > 0){
            System.out.println("Not enough notes");
        }
    }
}
