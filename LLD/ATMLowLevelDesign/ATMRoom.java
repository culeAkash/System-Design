package LLD.ATMLowLevelDesign;

public class ATMRoom {
    public ATMMachine atmMachine;
    public User user;


    public ATMRoom(){
        initialize();
    }

    public void initialize(){
        atmMachine = ATMMachine.getInstance();
        atmMachine.setBalance(10, 10, 10);

        createUser();
    }

    private void createUser() {
        this.user = new User();

        user.name = "Akash";
        user.bankAccount = createBankAccount();
        user.atmCard = createCard();
        user.atmCard.bankAccount = user.bankAccount;
    }

    private BankAccount createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.bankBalance = 10000;
        return bankAccount;
    }

    private ATMCard createCard() {
        ATMCard atmCard = new ATMCard();
        atmCard.atmPin = 310500;
        atmCard.cardHolderName = "Akash";
        atmCard.cardNumber = 1234567890;
        return atmCard;
    }
}
