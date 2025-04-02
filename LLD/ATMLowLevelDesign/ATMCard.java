package LLD.ATMLowLevelDesign;

public class ATMCard {
    public int atmPin;
    public int cardNumber;
    public String cardHolderName;
    public BankAccount bankAccount;

    public boolean isCardPinCorrect(int atmPin){
        return this.atmPin == atmPin;
    }

    public int getBalance(){
        return this.bankAccount.bankBalance;
    }

    public void deductBalance(int amount){
        this.bankAccount.bankBalance -= amount;
    }
}
