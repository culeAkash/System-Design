package LLD.ATMLowLevelDesign;

public class Main {
    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.atmMachine.printCurrentState();
        atmRoom.atmMachine.currentATMState.insertCard(atmRoom.atmMachine, atmRoom.user.atmCard);
        atmRoom.atmMachine.currentATMState.authenticatePin(atmRoom.atmMachine, atmRoom.user.atmCard, 310500);
        atmRoom.atmMachine.currentATMState.selectOperation(atmRoom.atmMachine, atmRoom.user.atmCard, TransactionType.CASHWiTHDRAWAL);
        atmRoom.atmMachine.currentATMState.withdrawCash(atmRoom.atmMachine, atmRoom.user.atmCard,10000);
        atmRoom.atmMachine.printCurrentState();

    }
}
