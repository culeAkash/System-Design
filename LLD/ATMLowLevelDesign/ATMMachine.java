package LLD.ATMLowLevelDesign;

import LLD.ATMLowLevelDesign.ATMState.ATMState;
import LLD.ATMLowLevelDesign.ATMState.impl.ATMIdleState;

public class ATMMachine {

    private static ATMMachine atmMachine = new ATMMachine();

    public ATMState currentATMState;
    public int balance;
    public int noOfTwoThousandNotes;
    public int noOfFiveHundredNotes;
    public int noOfOneHundredNotes;

    public static ATMMachine getInstance() {
        atmMachine.currentATMState = new ATMIdleState();
        return atmMachine;
    }

    public void deductTwoThousandNotes(int noOfTwoThousandNotes){
        this.noOfTwoThousandNotes -= noOfTwoThousandNotes;
        this.balance -= (noOfTwoThousandNotes * 2000);
    }

    public void deductFiveHundredNotes(int noOfFiveHundredNotes){
        this.noOfFiveHundredNotes -= noOfFiveHundredNotes;
        this.balance -= (noOfFiveHundredNotes * 500);
    }

    public void deductOneHundredNotes(int noOfOneHundredNotes){
        this.noOfOneHundredNotes -= noOfOneHundredNotes;
        this.balance -= (noOfOneHundredNotes * 100);
    }

    public void setBalance(int noOfTwoThousandNotes,int noOfFiveHundredNotes,int noOfOneHundredNotes){
        this.balance = (noOfTwoThousandNotes * 2000) + (noOfFiveHundredNotes * 500) + (noOfOneHundredNotes * 100);
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void printCurrentState() {
        System.out.println("Balance: " + balance);
        System.out.println("TwoThousand Notes: " + noOfTwoThousandNotes);
        System.out.println("FiveHundred Notes: " + noOfFiveHundredNotes);
        System.out.println("OneHundred Notes: " + noOfOneHundredNotes);
    }
}
