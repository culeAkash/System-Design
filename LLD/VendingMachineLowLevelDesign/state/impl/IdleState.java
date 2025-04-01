package LLD.VendingMachineLowLevelDesign.state.impl;

import LLD.VendingMachineLowLevelDesign.Coin;
import LLD.VendingMachineLowLevelDesign.VendingMachine;
import LLD.VendingMachineLowLevelDesign.state.State;

public class IdleState implements State{


    public IdleState() {
        
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        // change the state of the vending machine to insert cash state
        vendingMachine.vendingMachineState = new AcceptCoinsState();
        System.out.println("Vending machine is in accept coins state now");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pressInsertCoinButton'");
    }

    @Override
    public void pressSelectproductButton(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pressSelectproductButton'");
    }

    @Override
    public void enterProductCodeButton(VendingMachine vendingMachine, int shelfCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterProductCodeButton'");
    }

    @Override
    public void pressCancelButton(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pressCancelButton'");
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
