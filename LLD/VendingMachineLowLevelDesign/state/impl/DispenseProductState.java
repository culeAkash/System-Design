package LLD.VendingMachineLowLevelDesign.state.impl;

import LLD.VendingMachineLowLevelDesign.Coin;
import LLD.VendingMachineLowLevelDesign.VendingMachine;
import LLD.VendingMachineLowLevelDesign.state.State;

public class DispenseProductState implements State {

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pressInsertCashButton'");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
    }

    @Override
    public void pressSelectproductButton(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pressSelectproductButton'");
    }

    @Override
    public void enterProductCodeButton(VendingMachine vendingMachine, int shelfCode) throws Exception {
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
        vendingMachine.inventory.itemShelves.get(shelfCode - (101)).quantity--;
        System.out.println("Product dispensed");
        
    }

    @Override
    public void dispenseChange(VendingMachine vendingMachine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseChange'");
    }
    
}
