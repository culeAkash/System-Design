package LLD.ATMLowLevelDesign.WithdrawalProcessor;

import LLD.ATMLowLevelDesign.ATMMachine;

public class WithdrawalProcessor {
    
    WithdrawalProcessor nexWithdrawalProcessor;

    public WithdrawalProcessor(WithdrawalProcessor nextWithdrawalProcessor) {
        this.nexWithdrawalProcessor = nextWithdrawalProcessor;
    }

    public void processWithdrawal(ATMMachine atmMachine,int amount){
        if(nexWithdrawalProcessor!=null){
            nexWithdrawalProcessor.processWithdrawal(atmMachine, amount);
        }
    }
}
