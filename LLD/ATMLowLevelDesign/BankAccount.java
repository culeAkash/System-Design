package LLD.ATMLowLevelDesign;

public class BankAccount {
    public int bankBalance;

    public BankAccount(int bankBalance) {
        this.bankBalance = bankBalance;
    }

    public BankAccount() {
        //TODO Auto-generated constructor stub
    }

    public void deposit(int amount) {
        bankBalance += amount;
    }

    public void withdraw(int amount) {
        bankBalance -= amount;
    }
}
