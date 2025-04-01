package LLD.VendingMachineLowLevelDesign.state.impl;

import java.util.List;

import LLD.VendingMachineLowLevelDesign.Coin;
import LLD.VendingMachineLowLevelDesign.VendingMachine;
import LLD.VendingMachineLowLevelDesign.state.State;

public class AcceptCoinsState implements State {

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pressSelectproductButton'");
        
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        List<Coin> coinsInserted = vendingMachine.coinsInserted;
        coinsInserted.add(coin);
        System.out.printf("Coin %s inserted\n",coin.getValue());
    }

    @Override
    public void pressSelectproductButton(VendingMachine vendingMachine) {
        System.out.println("Insert coin button pressed, machine goes to accept product code state");
        vendingMachine.vendingMachineState = new AcceptProductCode();
    }

    @Override
    public void enterProductCodeButton(VendingMachine vendingMachine, int shelfCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterProductCodeButton'");
    }

    @Override
    public void pressCancelButton(VendingMachine vendingMachine) {
        System.out.println("Cancel button pressed, full refund in given and vending machine goes to idle state");
        vendingMachine.vendingMachineState = new IdleState();
        for(Coin coin : vendingMachine.coinsInserted){
            System.out.printf("Coin %s returned\n",coin.getValue());
            vendingMachine.coinsInserted.remove(coin);
        }        
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine,int shelfCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseProduct'");
    }

    @Override
    public void dispenseChange(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseChange'");
    }
    
}
